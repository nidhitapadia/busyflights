package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

import java.util.List;

/**
 * The interface Search flight for supplier.
 *
 * @param <T> the supplier request type
 * @param <R> the supplier response type
 */
public interface SearchFlightService<T, R> {
    /**
     * Convert BusyFlightsRequest to supplier request.
     *
     * @param busyFlightsRequest the busy flights request
     * @return the supplier request type
     */
    T convertRequest(BusyFlightsRequest busyFlightsRequest);

    /**
     * Perform search for the flights.
     *
     * @param request the request
     * @return the list of supplier response flight
     */
    List<R> performSearch(T request);

    /**
     * Convert supplier response flight to BusyFlightsResponse
     *
     * @param response he list of supplier response flight
     * @return the list of BusyFlightsResponse
     */
    List<BusyFlightsResponse> convertResponse(List<R> response);
}
