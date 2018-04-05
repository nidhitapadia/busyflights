package com.travix.medusa.busyflights.mock;


import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Mock crazy air controller.
 * Used only for test purpose. Should not be present in the production code
 */
@RestController
@RequestMapping("/v1/api/crazyair")
public class MockCrazyAirController {

    /**
     * Search response entity.
     *
     * @param crazyAirRequest the crazy air request
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<?> search(@RequestBody CrazyAirRequest crazyAirRequest) {
        return ResponseEntity.ok(createDummyResponse());
    }

    private List<CrazyAirResponse> createDummyResponse() {
        List<CrazyAirResponse> crazyAirResponses = new ArrayList<>();
        CrazyAirResponse car = new CrazyAirResponse();
        car.setAirline("KL");
        car.setArrivalDate(LocalDateTime.now().plusDays(1));
        car.setCabinclass("E");
        car.setDepartureAirportCode("AMS");
        car.setDepartureDate(LocalDateTime.now());
        car.setDestinationAirportCode("LHR");
        car.setPrice(123.2322);
        crazyAirResponses.add(car);

        car = new CrazyAirResponse();
        car.setAirline("AF");
        car.setArrivalDate(LocalDateTime.now().plusDays(1));
        car.setCabinclass("B");
        car.setDepartureAirportCode("AMS");
        car.setDepartureDate(LocalDateTime.now());
        car.setDestinationAirportCode("LHR");
        car.setPrice(423.2378);
        crazyAirResponses.add(car);
        return crazyAirResponses;
    }
}
