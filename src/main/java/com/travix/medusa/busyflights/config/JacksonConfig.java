package com.travix.medusa.busyflights.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Jackson config.
 */
@Configuration
public class JacksonConfig {
    /**
     * Parameter names module bean
     *
     * @return the module
     */
    @Bean
    public Module parameterNamesModule() {
        return new ParameterNamesModule(JsonCreator.Mode.PROPERTIES);
    }

    /**
     * Java time module bean
     *
     * @return the module
     */
    @Bean
    public Module javaTimeModule() {
        return new JavaTimeModule();
    }

    /**
     * Jdk 8 module bean
     *
     * @return the module
     */
    @Bean
    public Module jdk8Module() {
        return new Jdk8Module();
    }
}