package com.guzzh.collection.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * httpClint响应
 * @author guzzh
 * @since 2018-4-12
 */
@Configuration
public class RestConfiguration {
    @Autowired
    private RestTemplateBuilder builder;
    @Bean
    public RestTemplate restTemplate(){
        return builder.build();
    }
}
