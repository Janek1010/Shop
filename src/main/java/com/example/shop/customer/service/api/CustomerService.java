package com.example.shop.customer.service.api;

import com.example.shop.customer.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface CustomerService {
    void saveNewCustomer(Customer customer);
    List<Customer> findAllCustomers();
    Optional<Customer> findCustomerById(UUID uuid);
    Optional<Customer> findCustomerByPesel(String pesel);

    void updateCustomerById(UUID uuid, Customer customer);
}
