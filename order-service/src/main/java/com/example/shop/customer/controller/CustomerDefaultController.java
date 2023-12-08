package com.example.shop.customer.controller;

import com.example.shop.customer.entities.Customer;
import com.example.shop.customer.service.api.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerDefaultController {
    private final CustomerService customerService;
    @DeleteMapping("/api/customers/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") UUID uuid){
        customerService.delete(uuid);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/api/customers/{customerId}")
    public ResponseEntity<Void> putCustomer(@PathVariable("customerId") UUID uuid){
        Customer customer = Customer.builder().id(uuid).build();
        customerService.create(customer);
        return ResponseEntity.accepted().build();
    }
}
