package com.example.shop.customer.controller;

import com.example.shop.customer.mappers.CustomerMapper;
import com.example.shop.customer.model.GetCustomerResponse;
import com.example.shop.customer.model.GetCustomersResponse;
import com.example.shop.customer.model.dto.CustomerDTO;
import com.example.shop.customer.services.api.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    public final String CUSTOMER_PATH = "/api/customers";
    public final String CUSTOMER_PATH_ID = CUSTOMER_PATH +"/{customerId}";
    private final CustomerMapper customerMapper;
    private final CustomerService customerService;
    // mozna zwracac za pomoca ResponseEntity<Encja> wiec moge zrobic to Dto i w tym zwracac
    // jak juz bede pewny ze dziala to moze usunac to new ArrayLis, wojcik w projekcie ma be po prostu zapisuje przy inicjalizacji dobrze i nie trzeba sie w takie rzeczy bawic
    // na chuja jest @Singular?
    // musze wypisac sobie w notion notatki o tym czego sie nauczylem

    @GetMapping(CUSTOMER_PATH)
    public ResponseEntity<GetCustomersResponse> getCustomers(){
        return ResponseEntity.ok(GetCustomersResponse.builder().customers(customerService.findAllCustomers().stream().map(customerMapper::customerToCustomerDto).toList()).build());
    }
    @GetMapping(CUSTOMER_PATH_ID)
    public ResponseEntity<GetCustomerResponse> getCustomer(@PathVariable("customerId")UUID uuid){
        return ResponseEntity.ok(customerService.findCustomerById(uuid).map(customerMapper::customerToGetCustomerResponse).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
}
