package com.travix.medusa.busyflights.mock;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Mock tough jet response.
 */
public class MockToughJetResponse {

    /**
     * Mock tough jet response list.
     *
     * @return the list
     */
    public static List<ToughJetResponse> mock() {
        List<ToughJetResponse> toughJetResponses = new ArrayList<>();
        ToughJetResponse tjr = new ToughJetResponse();
        tjr.setCarrier("AF");
        tjr.setInboundDateTime(Instant.now().plus(1, ChronoUnit.DAYS));
        tjr.setArrivalAirportName("LHR");
        tjr.setDepartureAirportName("AMS");
        tjr.setOutboundDateTime(Instant.now());
        tjr.setBasePrice(400.234);
        tjr.setDiscount(10);
        tjr.setTax(5);
        toughJetResponses.add(tjr);

        tjr = new ToughJetResponse();
        tjr.setCarrier("DL");
        tjr.setInboundDateTime(Instant.now().plus(1, ChronoUnit.DAYS));
        tjr.setArrivalAirportName("LHR");
        tjr.setDepartureAirportName("AMS");
        tjr.setOutboundDateTime(Instant.now());
        tjr.setBasePrice(200.124);
        tjr.setDiscount(40.7);
        tjr.setTax(41.1);
        toughJetResponses.add(tjr);
        return toughJetResponses;
    }
}
