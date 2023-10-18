package com.example.shop.customer.controller;

import com.example.shop.customer.model.GetCustomersResponse;
import com.example.shop.customer.model.dto.CustomerDTO;
import com.example.shop.customer.services.api.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    public final String CUSTOMER_PATH = "/api/customers";
    public final String CUSTOMER_PATH_ID = CUSTOMER_PATH +"/{customerId}";
    private final CustomerService customerService;
    // mozna zwracac za pomoca ResponseEntity<Encja> wiec moge zrobic to Dto i w tym zwracac
    // jak juz bede pewny ze dziala to moze usunac to new ArrayLis, wojcik w projekcie ma be po prostu zapisuje przy inicjalizacji dobrze i nie trzeba sie w takie rzeczy bawic
    // na chuja jest @Singular?
    // musze wypisac sobie w notion notatki o tym czego sie nauczylem

    @GetMapping(CUSTOMER_PATH)
    public ResponseEntity<GetCustomersResponse> getCustomers(){
        return ResponseEntity.ok(GetCustomersResponse.builder().customers(customerService.findAllCustomers()).build());
    }
}
