package com.travix.medusa.busyflights.service.crazyair;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.travix.medusa.busyflights.domain.busyflights.Supplier.CrazyAir;

/**
 * The type Crazy air search flight.
 */
@Service
public class CrazyAirSearchFlightsService implements SearchFlightsService<CrazyAirRequest, CrazyAirResponse> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrazyAirSearchFlightsService.class);

    @Value("${provider.crazyair.endpoint}")
    private String crazyAirEndpoint;

    @Value("${provider.crazyair.key}")
    private String crazyAirKey;

    @Autowired
    private RetrieveFlightsService retrieveFlightsService;

    @Override
    public CrazyAirRequest convertRequest(BusyFlightsRequest busyFlightsRequest) {
        CrazyAirRequest crazyAirRequest = null;
        if (busyFlightsRequest != null) {
            crazyAirRequest = new CrazyAirRequest();
            crazyAirRequest.setOrigin(busyFlightsRequest.getOrigin());
            crazyAirRequest.setDestination(busyFlightsRequest.getDestination());
            crazyAirRequest.setDepartureDate(busyFlightsRequest.getDepartureDate());
            crazyAirRequest.setReturnDate(busyFlightsRequest.getReturnDate());
            crazyAirRequest.setPassengerCount(busyFlightsRequest.getNumberOfPassengers());
        }
        return crazyAirRequest;
    }

    @Override
    public List<CrazyAirResponse> performSearch(CrazyAirRequest request) {
        List<CrazyAirResponse> responses = null;
        try {
            responses = Arrays.asList(retrieveFlightsService.callApi(crazyAirEndpoint, crazyAirKey, request, CrazyAirResponse[].class));
        } catch (RestClientException restClientException) {
            //We do not stop processing if one service fails to give details. Error is logged.
            LOGGER.error("Received RestClientException with message ({}) while getting flight details from CrazyAir api", restClientException.getMessage());
        }
        return responses;
    }

    @Override
    public List<BusyFlightsResponse> convertResponse(List<CrazyAirResponse> response) {
        return Optional
                .ofNullable(response)
                .map(r -> r.stream().map(this::convertToBusyFlightsResponse).collect(Collectors.toList()))
                .orElse(Collections.EMPTY_LIST);

    }

    private BusyFlightsResponse convertToBusyFlightsResponse(CrazyAirResponse crazyAirResponse) {
        BusyFlightsResponse busyFlightsResponse = null;
        if (crazyAirResponse != null) {
            busyFlightsResponse = new BusyFlightsResponse(CrazyAir);
            busyFlightsResponse.setAirline(crazyAirResponse.getAirline());
            busyFlightsResponse.setDepartureAirportCode(crazyAirResponse.getDepartureAirportCode());
            busyFlightsResponse.setDestinationAirportCode(crazyAirResponse.getDestinationAirportCode());
            busyFlightsResponse.setDepartureDate(crazyAirResponse.getDepartureDate().atZone(ZoneId.systemDefault()));
            busyFlightsResponse.setArrivalDate(crazyAirResponse.getArrivalDate().atZone(ZoneId.systemDefault()));
            busyFlightsResponse.setFare(ConversionUtils.toDecimalValueWithTwoDigitPrecision(crazyAirResponse.getPrice()));
        }
        return busyFlightsResponse;
    }



}
