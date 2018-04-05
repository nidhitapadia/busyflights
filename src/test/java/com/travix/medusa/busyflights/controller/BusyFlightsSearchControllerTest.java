package com.travix.medusa.busyflights.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.mock.MockBusyFlightRequest;
import com.travix.medusa.busyflights.mock.MockCrazyAirResponse;
import com.travix.medusa.busyflights.mock.MockToughJetResponse;
import com.travix.medusa.busyflights.service.BusyFlightsSearchService;
import com.travix.medusa.busyflights.service.crazyair.CrazyAirSearchFlightsService;
import com.travix.medusa.busyflights.service.toughjet.ToughJetSearchFlightsService;
import com.travix.medusa.busyflights.util.BusyFlightsConstant;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BusyFlightsSearchControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CrazyAirSearchFlightsService crazyAirSearchFlightsService;

    @MockBean
    private ToughJetSearchFlightsService toughJetSearchFlightsService;

    @InjectMocks
    private BusyFlightsSearchService busyFlightsSearchService;

    @InjectMocks
    private BusyFlightsSearchController busyFlightsSearchController;

    private JacksonTester<BusyFlightsRequest> jsonTester;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        JacksonTester.initFields(this, objectMapper);
        ReflectionTestUtils.setField(busyFlightsSearchService, "searchFlightsServices", Arrays.asList(crazyAirSearchFlightsService, toughJetSearchFlightsService));
        ReflectionTestUtils.setField(busyFlightsSearchController, "busyFlightsSearchService", busyFlightsSearchService);
        given(crazyAirSearchFlightsService.performSearch(any(CrazyAirRequest.class))).willReturn(MockCrazyAirResponse.mock());
        given(crazyAirSearchFlightsService.convertResponse(any(List.class))).willCallRealMethod();
        given(toughJetSearchFlightsService.performSearch(any(ToughJetRequest.class))).willReturn(MockToughJetResponse.mock());
        given(toughJetSearchFlightsService.convertResponse(any(List.class))).willCallRealMethod();
    }

    @Test
    public void testNullRequest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(BusyFlightsConstant.BUSY_FLIGHTS_SEARCH_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testValidRequest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(BusyFlightsConstant.BUSY_FLIGHTS_SEARCH_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonTester.write(MockBusyFlightRequest.mockValidRequest()).getJson()))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("[0].airline", Matchers.is("KL")))
                .andExpect(jsonPath("[0].fare", Matchers.is("1.10")))
                .andExpect(jsonPath("[1].airline", Matchers.is("DL")))
                .andExpect(jsonPath("[1].fare", Matchers.is("159.77")))
                .andExpect(jsonPath("[2].airline", Matchers.is("AF")))
                .andExpect(jsonPath("[2].fare", Matchers.is("365.21")))
                .andExpect(jsonPath("[3].airline", Matchers.is("KQ")))
                .andExpect(jsonPath("[3].fare", Matchers.is("500.46")))
        ;
    }

    @Test
    public void testRequestWithInValidOrigin() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(BusyFlightsConstant.BUSY_FLIGHTS_SEARCH_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonTester.write(MockBusyFlightRequest.mockRequestWithInValidOrigin()).getJson()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testRequestWithInValidDestination() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(BusyFlightsConstant.BUSY_FLIGHTS_SEARCH_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonTester.write(MockBusyFlightRequest.mockRequestWithInValidDestination()).getJson()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testRequestWithInValidNumberOfPassengers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(BusyFlightsConstant.BUSY_FLIGHTS_SEARCH_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonTester.write(MockBusyFlightRequest.mockRequestWithInValidNumberOfPassengers()).getJson()))
                .andExpect(status().isBadRequest());
    }
}