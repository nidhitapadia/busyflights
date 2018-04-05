package com.travix.medusa.busyflights.mock;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

import java.time.LocalDate;

/**
 * The type Mock Busy Flight Request.
 */
public class MockBusyFlightRequest {


    /**
     * Mock valid busy flights request.
     *
     * @return the busy flights request
     */
    public static BusyFlightsRequest mockValidRequest() {
        return busyFlightsRequest("AMS", "CDG", LocalDate.now(), LocalDate.now().plusDays(5), 4);
    }


    /**
     * Mock busy flights request with invalid origin
     *
     * @return the busy flights request
     */
    public static BusyFlightsRequest mockRequestWithInValidOrigin() {
        return busyFlightsRequest("AM", "CDG", LocalDate.now(), LocalDate.now().plusDays(5), 4);
    }

    /**
     * Mock busy flights request with invalid origin
     *
     * @return the busy flights request
     */
    public static BusyFlightsRequest mockRequestWithInValidDestination() {
        return busyFlightsRequest("AMS", "CDGW", LocalDate.now(), LocalDate.now().plusDays(5), 4);
    }

    /**
     * Mock busy flights request with invalid number of passengers
     *
     * @return the busy flights request
     */
    public static BusyFlightsRequest mockRequestWithInValidNumberOfPassengers() {
        return busyFlightsRequest("AMS", "CDG", LocalDate.now(), LocalDate.now().plusDays(5), 5);
    }

    private static BusyFlightsRequest busyFlightsRequest(final String origin,
                                                         final String destination,
                                                         final LocalDate departureDate,
                                                         final LocalDate returnDate,
                                                         final int numberOfPassengers) {
        BusyFlightsRequest busyFlightsRequest = new BusyFlightsRequest();
        busyFlightsRequest.setOrigin(origin);
        busyFlightsRequest.setDestination(destination);
        busyFlightsRequest.setDepartureDate(departureDate);
        busyFlightsRequest.setReturnDate(returnDate);
        busyFlightsRequest.setNumberOfPassengers(numberOfPassengers);
        return busyFlightsRequest;
    }
}
