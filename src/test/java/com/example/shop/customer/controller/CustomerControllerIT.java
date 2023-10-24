package com.example.shop.customer.controller;


import com.example.shop.customer.entities.Customer;
import com.example.shop.customer.mappers.CustomerMapper;
import com.example.shop.customer.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DisplayName("Integration tests of CustomerController")
class CustomerControllerIT {
    @Autowired
    CustomerController customerController;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();
    }

    @Test
    @DisplayName("Should return all customers")
    void getCustomers() throws Exception {
        mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers").isArray())
                .andExpect(jsonPath("$.customers.length()").value(5));
    }
    @Test
    @DisplayName("Should return customer by id")
    void getCustomer() throws Exception {
        Customer customer = customerRepository.findAll().get(0);
        mockMvc.perform(get("/api/customers/"+customer.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(customer.getId().toString()))
                .andExpect(jsonPath("$.name").value(customer.getName()))
                .andExpect(jsonPath("$.surname").value(customer.getSurname()))
                .andExpect(jsonPath("$.pesel").value(customer.getPesel()))
                .andExpect(jsonPath("$.age").value(customer.getAge()));
    }

    @Test
    @DisplayName("Should return 404 when customer not found")
    void getCustomerNotFound() throws Exception {
        mockMvc.perform(get("/api/customers/"+ UUID.randomUUID().toString()))
                .andExpect(status().isNotFound());
    }
    @Test
    //@Disabled
    @DisplayName("Should update customer sending body")
    void putCustomer() throws Exception {

        Customer customer = customerRepository.findAll().get(0);
        customer.setName("New name");
        customer.setSurname("New surname");
        customer.setAge(99);
        System.out.println(customer.getOrders().size());

        mockMvc.perform(put("/api/customers/"+customer.getId().toString())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk());

        System.out.println("pomiedzy");
        mockMvc.perform(get("/api/customers/"+customer.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(customer.getId().toString()))
                .andExpect(jsonPath("$.name").value(customer.getName()))
                .andExpect(jsonPath("$.surname").value(customer.getSurname()))
                .andExpect(jsonPath("$.pesel").value(customer.getPesel()))
                .andExpect(jsonPath("$.age").value(customer.getAge()));
        System.out.println("po");
    }


}