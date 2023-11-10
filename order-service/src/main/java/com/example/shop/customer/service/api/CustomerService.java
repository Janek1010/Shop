package com.example.shop.customer.service.api;

import com.example.shop.customer.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface CustomerService {
    Optional<Customer> findCustomerById(UUID uuid);
    void createCustomer(Customer customer);
    void deleteCustomerById(UUID uuid);
}
