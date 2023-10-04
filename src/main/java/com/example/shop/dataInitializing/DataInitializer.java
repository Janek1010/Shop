package com.example.shop.dataInitializing;

import com.example.shop.entities.Customer;
import com.example.shop.entities.Order;
import com.example.shop.services.CustomerService;
import com.example.shop.services.CustomerServiceJPA;
import com.example.shop.services.OrderService;
import com.example.shop.services.OrderServiceJPA;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private static final List<String> products = List.of("Piwo IPA", "Piwo APA", "Pomidor", "Mango", "Młotek");
    private static final List<String> names = List.of("Jan Kowalski", "Zbigniew Noga", "Jacek Jackowski", "Marek Markowski", "Jurek Jurkowski");

    private final CustomerService customerServiceJPA;
    private final OrderService orderServiceJPA;


    @PostConstruct
    public void initializeData() {
        Random rand = new Random();

        for (String n : names) {
            Customer customer = Customer.builder().name(n).id(UUID.randomUUID()).age(rand.nextInt(80) + 20).build();
            Customer savedCustomer =  customerServiceJPA.saveNewCustomer(customer);
            for (int i = 0; i < rand.nextInt(5) + 3; i++) {
                Order order = Order.builder().customer(savedCustomer).id(UUID.randomUUID()).productName(products.get(rand.nextInt(5))).quantity(rand.nextInt(500) + 10).build();
                orderServiceJPA.saveNewOrder(order);
            }
        }
    }
}
