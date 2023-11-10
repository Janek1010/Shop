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
    public Optional<Customer> findCustomerById(UUID uuid) {
        return customerRepository.findById(uuid);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(UUID uuid) {
        customerRepository.findById(uuid).ifPresent(customerRepository::delete);
    }
}
