package com.example.shop.services;

import com.example.shop.entities.Customer;
import com.example.shop.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService{
    private final CustomerRepository customerRepository;

    @Override
    public Customer saveNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

}
