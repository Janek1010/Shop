package com.example.shop.customer.services.impl;

import com.example.shop.customer.entities.Customer;
import com.example.shop.customer.mappers.CustomerMapper;
import com.example.shop.customer.model.dto.CustomerDTO;
import com.example.shop.customer.repositories.CustomerRepository;
import com.example.shop.customer.services.api.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Override
    public Customer saveNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::customerToCustomerDto).toList();
    }

    @Override
    public Optional<Customer> findCustomerById(UUID uuid) {
        return customerRepository.findById(uuid);
    }

    @Override
    public Optional<Customer> findCustomerByPesel(String pesel) {
        return customerRepository.findCustomerByPesel(pesel);
    }

}
