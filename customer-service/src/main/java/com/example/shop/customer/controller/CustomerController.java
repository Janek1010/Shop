package com.example.shop.customer.controller;

import com.example.shop.customer.mappers.CustomerMapper;
import com.example.shop.customer.model.GetCustomerResponse;
import com.example.shop.customer.model.GetCustomersResponse;
import com.example.shop.customer.model.PutCustomerRequest;
import com.example.shop.customer.model.dto.CustomerDTO;
import com.example.shop.customer.service.api.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    public final String CUSTOMER_PATH = "/api/customers";
    public final String CUSTOMER_PATH_ID = CUSTOMER_PATH +"/{customerId}";
    private final CustomerMapper customerMapper;
    private final CustomerService customerService;
    @GetMapping(CUSTOMER_PATH)
    public ResponseEntity<GetCustomersResponse> getCustomers(){
        return ResponseEntity.ok(GetCustomersResponse.builder().customers(customerService.findAllCustomers().stream().map(customerMapper::customerToCustomerDto).toList()).build());
    }
    @GetMapping(CUSTOMER_PATH_ID)
    public ResponseEntity<GetCustomerResponse> getCustomer(@PathVariable("customerId")UUID uuid){
        return ResponseEntity.ok(customerService.findCustomerById(uuid).map(customerMapper::customerToGetCustomerResponse).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
    @PutMapping(CUSTOMER_PATH_ID)
    public ResponseEntity<Void> putCustomer(@PathVariable("customerId") UUID uuid, @RequestBody PutCustomerRequest request){
        customerService.updateCustomerById(uuid, customerMapper.putCustomerRequestToCustomer(request));
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(CUSTOMER_PATH_ID)
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") UUID uuid){
        customerService.deleteCustomerById(uuid);
        return ResponseEntity.accepted().build();
    }
}
