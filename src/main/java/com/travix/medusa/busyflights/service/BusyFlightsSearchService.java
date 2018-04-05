package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Busy flight search.
 */
@Service
public class BusyFlightsSearchService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusyFlightsSearchService.class);

    @Autowired
    private List<SearchFlightService> searchFlightServices;

    /**
     * Search flights for busyFlightsRequest
     *
     * @param busyFlightsRequest the busyFlightsRequest
     */
    public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest busyFlightsRequest) {
         return searchFlightServices.parallelStream()
                 .map(sf -> getList(busyFlightsRequest, sf))
                 .flatMap(List::stream)
                 .sorted(Comparator.comparing(bf -> Double.valueOf(bf.getFare())))
                 .collect(Collectors.toList());
    }

    private List<BusyFlightsResponse> getList(BusyFlightsRequest busyFlightsRequest, SearchFlightService searchFlightService) {
        List<BusyFlightsResponse> response = null;
        try {
            response = searchFlightService.convertResponse(searchFlightService.performSearch(searchFlightService.convertRequest(busyFlightsRequest)));
        } catch (Exception exception) {
            LOGGER.error("Received exception while retrieving flight details for busyFlightsRequest ({}) and searchFlightService ({})", busyFlightsRequest, searchFlightService.getClass().getName());
        }
        return response;
    }
}
