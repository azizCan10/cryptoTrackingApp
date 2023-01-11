package com.test.cryptotrackapp.config;

import com.test.cryptotrackapp.exception.RestTemplateResponseErrorHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Configuration
public class RestTemplateConfig {

    private final RestTemplateResponseErrorHandler responseErrorHandler;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().errorHandler(responseErrorHandler).build();
    }
}
