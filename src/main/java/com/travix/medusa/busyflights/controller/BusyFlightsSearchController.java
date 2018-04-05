package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.service.BusyFlightsSearchService;
import com.travix.medusa.busyflights.util.BusyFlightsConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * The type Busy flight search controller.
 */
@RestController
@RequestMapping(BusyFlightsConstant.BUSY_FLIGHTS_SEARCH_ENDPOINT)
public class BusyFlightsSearchController {

    @Autowired
    private BusyFlightsSearchService busyFlightsSearchService;

    /**
     * Search flights response entity.
     *
     * @param busyFlightsRequest the busy flights request
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity searchFlights(@Validated @RequestBody BusyFlightsRequest busyFlightsRequest) {
        return Optional.ofNullable(busyFlightsRequest)
                .map(busyFlightsSearchService::searchFlights)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}
