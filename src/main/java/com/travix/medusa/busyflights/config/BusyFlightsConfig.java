package com.travix.medusa.busyflights.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * The type Busy flights config.
 */
@Configuration
public class BusyFlightsConfig {

    /**
     * Rest template bean.
     *
     * @return the rest template
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
