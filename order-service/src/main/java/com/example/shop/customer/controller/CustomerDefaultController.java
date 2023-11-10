package com.example.shop.customer.controller;

import com.example.shop.customer.service.api.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CustomerDefaultController {
    private final CustomerService customerService;
    @DeleteMapping("/api/customers/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") UUID uuid){
        customerService.deleteCustomerById(uuid);
        return ResponseEntity.accepted().build();
    }
}
