package com.example.shop.customer.service.impl;

import com.example.shop.customer.entities.Customer;
import com.example.shop.customer.repository.CustomerRepository;
import com.example.shop.customer.service.api.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> find(UUID id) {
        return customerRepository.findById(id);
    }

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(UUID id) {
        customerRepository.findById(id).ifPresent(customerRepository::delete);
    }
}
