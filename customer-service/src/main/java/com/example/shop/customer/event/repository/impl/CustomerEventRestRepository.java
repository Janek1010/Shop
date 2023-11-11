package com.example.shop.customer.event.repository.impl;

import com.example.shop.customer.entities.Customer;
import com.example.shop.customer.event.repository.api.CustomerEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class CustomerEventRestRepository implements CustomerEventRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public CustomerEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public void delete(UUID uuid) {
        restTemplate.delete("/api/customers/{customerId}", uuid);
    }

    @Override
    public void create(UUID uuid) {
        Customer customer = Customer.builder().build();
        restTemplate.put("/api/customers/{customerId}",customer, uuid);
    }
}
