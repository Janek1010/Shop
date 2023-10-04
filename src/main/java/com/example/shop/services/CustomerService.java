package com.example.shop.services;

import com.example.shop.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer saveNewCustomer(Customer customer);
    List<Customer> findAllCustomers();
}
