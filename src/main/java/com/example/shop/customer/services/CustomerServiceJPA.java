package com.example.shop.customer.services;

import com.example.shop.customer.entities.Customer;
import com.example.shop.customer.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Optional<Customer> findCustomerById(UUID uuid) {
        return customerRepository.findById(uuid);
    }

    @Override
    public Optional<Customer> findCustomerByPesel(String pesel) {
        return customerRepository.findCustomerByPesel(pesel);
    }

}
