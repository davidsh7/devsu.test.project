package com.devsu.test.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * The Class RestTemplateConfig.
 * 
 * @author David Sepulveda
 */
@Configuration
public class RestTemplateConfig {

    /**
     * Rest template.
     *
     * @return the rest template
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}