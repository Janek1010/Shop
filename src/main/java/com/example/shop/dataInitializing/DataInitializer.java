package com.example.shop.dataInitializing;

import com.example.shop.customer.entities.Customer;
import com.example.shop.customer.entities.Order;
import com.example.shop.customer.services.api.CustomerService;
import com.example.shop.customer.services.api.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class DataInitializer implements InitializingBean {
    private static final List<String> products = List.of("Piwo IPA", "Piwo APA", "Pomidor", "Mango", "Młotek");
    private static final List<String> names = List.of("Jan", "Zbigniew", "Jacek", "Marek", "Jurek");
    private static final List<String> surnames = List.of("Kowalski", "Noga", "Jackowski", "Markowski", "Jurkowski");
    private static final List<String> pesels = List.of("64093021258", "77040615488", "01242237333", "51022797418", "65102159889");

    private final CustomerService customerServiceJPA;
    private final OrderService orderServiceJPA;


    @Override
    public void afterPropertiesSet() throws Exception {
        Random rand = new Random();
        int peselIndex = -1;
        int surnameIndex = -1;
        for (String n : names) {
            peselIndex++;
            surnameIndex++;
            Customer customer = Customer.builder().name(n).id(UUID.randomUUID()).age(rand.nextInt(80) + 20).surname(surnames.get(surnameIndex)).pesel(pesels.get(peselIndex)).build();
            customerServiceJPA.saveNewCustomer(customer);
            for (int i = 0; i < rand.nextInt(5) + 3; i++) {
                Order order = Order.builder()
                        .customer(customer)
                        .id(UUID.randomUUID())
                        .productName(products.get(rand.nextInt(5)))
                        .quantity(rand.nextInt(500) + 10)
                        .build();
                orderServiceJPA.saveNewOrder(order);
            }
        }
    }
}
