package com.example.shop;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("customer-service", r -> r
                        .path("/api/customers/{customerId}")
                        .or()
                        .path("/api/customers")
                        .uri("http://localhost:8082")
                )
                .route("order-service", r -> r
                        .path("/api/orders")
                        .or()
                        .path("/api/orders/**")
                        .or()
                        .path("/api/customers/{customerId}/orders")
                        .or()
                        .path("/api/customers/{customerId}/orders/**")
                        .uri("http://localhost:8081")
                )
                .build();
    }
}
