package com.example.shop.customer.services;

import com.example.shop.customer.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface CustomerService {
    Customer saveNewCustomer(Customer customer);
    List<Customer> findAllCustomers();
    Optional<Customer> findCustomerById(UUID uuid);
    Optional<Customer> findCustomerByPesel(String pesel);
}
