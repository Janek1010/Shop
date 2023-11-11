package com.example.shop.order.initialize;

import com.example.shop.customer.entities.Customer;
import com.example.shop.order.entity.Order;
import com.example.shop.customer.service.api.CustomerService;
import com.example.shop.order.service.api.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class DataInitializer implements InitializingBean {

    private final CustomerService customerServiceJPA;
    private final OrderService orderServiceJPA;


    @Override
    public void afterPropertiesSet() throws Exception {

        if (orderServiceJPA.findAllOrders().isEmpty()) {


            Customer customer = Customer.builder()
                    .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                    .build();
            Customer customer1 = Customer.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                    .build();

            Customer customer2 = Customer.builder()
                    .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                    .build();

            Customer customer3 = Customer.builder()
                    .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8ef"))
                    .build();

            customerServiceJPA.create(customer);
            customerServiceJPA.create(customer1);
            customerServiceJPA.create(customer2);
            customerServiceJPA.create(customer3);

            Order krzeslo = Order.builder()
                    .id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0"))
                    .productName("krzeslo")
                    .customer(customer)
                    .quantity(15)
                    .build();

            Order ogorek = Order.builder()
                    .id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4f2"))
                    .productName("ogorek")
                    .customer(customer)
                    .quantity(2)
                    .build();
            orderServiceJPA.saveOrder(krzeslo);
            orderServiceJPA.saveOrder(ogorek);
            // 2gi customer

            Order miod = Order.builder()
                    .id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-286d1a12e4c0"))
                    .productName("miod")
                    .customer(customer1)
                    .quantity(113)
                    .build();

            Order monitor = Order.builder()
                    .id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-106d1a12e4f2"))
                    .productName("monitor")
                    .customer(customer1)
                    .quantity(7)
                    .build();
            orderServiceJPA.saveOrder(miod);
            orderServiceJPA.saveOrder(monitor);
//
//            // 3ci customer
            Order biurko = Order.builder()
                    .id(UUID.fromString("285d3e7b-bb1f-4c13-bf17-286d1a12e4c0"))
                    .productName("biurko")
                    .customer(customer2)
                    .quantity(85)
                    .build();

            Order okno = Order.builder()
                    .id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-106d1a12e4f2"))
                    .productName("okno")
                    .customer(customer2)
                    .quantity(766)
                    .build();
            orderServiceJPA.saveOrder(biurko);
            orderServiceJPA.saveOrder(okno);
//            // 4ty customer

            Order dzbanek = Order.builder()
                    .id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-106d1a12e4f0"))
                    .productName("dzbanek")
                    .customer(customer3)
                    .quantity(2323)
                    .build();

            Order sciana = Order.builder()
                    .id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-106d1a12e4e0"))
                    .productName("sciana")
                    .customer(customer3)
                    .quantity(422)
                    .build();
            orderServiceJPA.saveOrder(dzbanek);
            orderServiceJPA.saveOrder(sciana);

        }
    }
}
