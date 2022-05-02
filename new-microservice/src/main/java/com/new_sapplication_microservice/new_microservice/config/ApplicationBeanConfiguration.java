package com.new_sapplication_microservice.new_microservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApplicationBeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }
}
