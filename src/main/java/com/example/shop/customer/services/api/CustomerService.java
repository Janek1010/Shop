package com.example.shop.customer.services.api;

import com.example.shop.customer.entities.Customer;
import com.example.shop.customer.model.dto.CustomerDTO;
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
}
