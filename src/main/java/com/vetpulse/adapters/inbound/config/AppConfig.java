package com.vetpulse.adapters.inbound.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.ZoneId;

@Configuration
public class AppConfig {

    @Value("${app.timezone}")
    private String timezone;
    
    @Bean
    public Clock clock() {
        return Clock.system(ZoneId.of(timezone));
    }
}
