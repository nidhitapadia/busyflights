package com.travix.medusa.busyflights.service.toughjet;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.service.RetrieveFlightsService;
import com.travix.medusa.busyflights.service.SearchFlightsService;
import com.travix.medusa.busyflights.util.ConversionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.travix.medusa.busyflights.domain.busyflights.Supplier.ToughJet;

/**
 * The type Tough jet search flight.
 */
@Service
public class ToughJetSearchFlightsService implements SearchFlightsService<ToughJetRequest, ToughJetResponse> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ToughJetSearchFlightsService.class);

    @Value("${provider.toughjet.endpoint}")
    private String toughjetEndpoint;

    @Value("${provider.toughjet.key}")
    private String toughjetKey;

    @Autowired
    private RetrieveFlightsService retrieveFlightsService;

    @Override
    public ToughJetRequest convertRequest(BusyFlightsRequest busyFlightsRequest) {
        ToughJetRequest toughJetRequest = null;
        if (busyFlightsRequest != null) {
            toughJetRequest = new ToughJetRequest();
            toughJetRequest.setFrom(busyFlightsRequest.getOrigin());
            toughJetRequest.setTo(busyFlightsRequest.getDestination());
            toughJetRequest.setInboundDate(busyFlightsRequest.getDepartureDate());
            toughJetRequest.setOutboundDate(busyFlightsRequest.getReturnDate());
            toughJetRequest.setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers());
        }
        return toughJetRequest;
    }

    @Override
    public List<ToughJetResponse> performSearch(ToughJetRequest request) {
        try {
            return Arrays.asList(retrieveFlightsService.callApi(toughjetEndpoint, toughjetKey, request, ToughJetResponse[].class));
        } catch (RestClientException restClientException) {
            //Process does not stop if one service fails to give details. Error is logged.
            LOGGER.error("Received RestClientException with message ({}) while getting flight details from ToughJet api", restClientException.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<BusyFlightsResponse> convertResponse(List<ToughJetResponse> response) {
        return Optional
                .ofNullable(response)
                .map(r -> r.stream().map(this::convertToBusyFlightsResponse).collect(Collectors.toList()))
                .orElse(Collections.EMPTY_LIST);
    }

    private BusyFlightsResponse convertToBusyFlightsResponse(ToughJetResponse toughJetResponse) {
        BusyFlightsResponse busyFlightsResponse = null;
        if (toughJetResponse != null) {
            busyFlightsResponse = new BusyFlightsResponse(ToughJet);
            busyFlightsResponse.setAirline(toughJetResponse.getCarrier());
            busyFlightsResponse.setDepartureAirportCode(toughJetResponse.getDepartureAirportName());
            busyFlightsResponse.setDestinationAirportCode(toughJetResponse.getArrivalAirportName());
            busyFlightsResponse.setDepartureDate(toughJetResponse.getInboundDateTime().atZone(ZoneId.systemDefault()));
            busyFlightsResponse.setArrivalDate(toughJetResponse.getInboundDateTime().atZone(ZoneId.systemDefault()));
            double totalPrice = toughJetResponse.getBasePrice() * (1 - toughJetResponse.getDiscount() / 100) + toughJetResponse.getTax();
            busyFlightsResponse.setFare(ConversionUtils.toDecimalValueWithTwoDigitPrecision(totalPrice));
        }
        return busyFlightsResponse;
    }
}
