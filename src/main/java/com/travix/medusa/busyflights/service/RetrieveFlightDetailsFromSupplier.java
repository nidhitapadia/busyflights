package com.travix.medusa.busyflights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * The type Retrieve flight details from supplier.
 */
@Service
public class RetrieveFlightDetailsFromSupplier {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * Gets response from supplier api
     *
     * @param <T>           the supplier response
     * @param <R>           the supplier request
     * @param apiEndpoint   the api endpoint
     * @param apiKey        the api key
     * @param request       the supplier request
     * @param responseClass the supplier response class
     * @return the response from supplier api
     */
    public <T, R> T callApi(String apiEndpoint, String apiKey, R request, Class<T> responseClass) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("api_key", apiKey);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<R> httpEntityRequest = new HttpEntity<>(request, requestHeaders);
        return restTemplate.postForObject(apiEndpoint, httpEntityRequest, responseClass);
    }
}
