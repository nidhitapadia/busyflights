package com.travix.medusa.busyflights.mock;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Mock crazy air response.
 */
public class MockCrazyAirResponse {

    /**
     * Mock crazy air response list.
     *
     * @return the list
     */
    public static List<CrazyAirResponse> mock() {
        List<CrazyAirResponse> crazyAirResponses = new ArrayList<>();
        CrazyAirResponse car = new CrazyAirResponse();
        car.setAirline("KL");
        car.setArrivalDate(LocalDateTime.now().plusDays(1));
        car.setCabinclass("E");
        car.setDepartureAirportCode("AMS");
        car.setDepartureDate(LocalDateTime.now());
        car.setDestinationAirportCode("LHR");
        car.setPrice(1.1);
        crazyAirResponses.add(car);

        car = new CrazyAirResponse();
        car.setAirline("KQ");
        car.setArrivalDate(LocalDateTime.now().plusDays(1));
        car.setCabinclass("B");
        car.setDepartureAirportCode("AMS");
        car.setDepartureDate(LocalDateTime.now());
        car.setDestinationAirportCode("LHR");
        car.setPrice(500.456);
        crazyAirResponses.add(car);
        return crazyAirResponses;
    }
}
