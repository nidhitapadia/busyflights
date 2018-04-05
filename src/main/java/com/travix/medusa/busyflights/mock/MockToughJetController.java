package com.travix.medusa.busyflights.mock;


import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Mock tough jet controller.
 */
@RestController
@RequestMapping("/v1/api/toughjet")
public class MockToughJetController {

    /**
     * Search response entity.
     *
     * @param toughJetRequest the tough jet request
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<?> search(@RequestBody ToughJetRequest toughJetRequest) {
        return ResponseEntity.ok(createDummyResponse());
    }

    private List<ToughJetResponse> createDummyResponse() {
        List<ToughJetResponse> toughJetResponses = new ArrayList<>();
        ToughJetResponse tjr = new ToughJetResponse();
        tjr.setCarrier("DL");
        tjr.setInboundDateTime(Instant.now().plus(1, ChronoUnit.DAYS));
        tjr.setArrivalAirportName("LHR");
        tjr.setDepartureAirportName("AMS");
        tjr.setOutboundDateTime(Instant.now());
        tjr.setBasePrice(156.124);
        tjr.setDiscount(23.7);
        tjr.setTax(15.6);
        toughJetResponses.add(tjr);

        tjr = new ToughJetResponse();
        tjr.setCarrier("KQ");
        tjr.setInboundDateTime(Instant.now().plus(1, ChronoUnit.DAYS));
        tjr.setArrivalAirportName("LHR");
        tjr.setDepartureAirportName("AMS");
        tjr.setOutboundDateTime(Instant.now());
        tjr.setBasePrice(100.00);
        tjr.setDiscount(20.0);
        tjr.setTax(15.75);
        toughJetResponses.add(tjr);
        return toughJetResponses;
    }
}
