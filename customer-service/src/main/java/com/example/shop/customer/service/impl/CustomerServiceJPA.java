package com.example.shop.customer.service.impl;

import com.example.shop.customer.entities.Customer;
import com.example.shop.customer.event.repository.impl.CustomerEventRestRepository;
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
    private final CustomerEventRestRepository customerEventRestRepository;

    @Override
    public void saveNewCustomer(Customer customer) {
        customerRepository.save(customer);
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
    public void updateCustomerById(UUID uuid, Customer customer) {
        customer.setId(uuid);
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(UUID uuid) {
        customerRepository.deleteById(uuid);
        customerEventRestRepository.delete(uuid);

    }
}
