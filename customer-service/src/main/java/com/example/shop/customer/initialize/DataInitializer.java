package com.example.shop.customer.initialize;

import com.example.shop.customer.entities.Customer;
import com.example.shop.customer.service.api.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class DataInitializer implements InitializingBean {
    private final CustomerService customerServiceJPA;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (customerServiceJPA.findAllCustomers().isEmpty()) {
            Customer customer = Customer.builder()
                    .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                    .name("Jan")
                    .age(18)
                    .pesel("64093021258")
                    .surname("Kowalski")
                    .build();
            Customer customer1 = Customer.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                    .name("Zbigniew")
                    .age(20)
                    .pesel("77040615488")
                    .surname("Noga")
                    .build();

            Customer customer2 = Customer.builder()
                    .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                    .name("Jacek")
                    .age(21)
                    .pesel("01242237333")
                    .surname("Jackowski")
                    .build();

            Customer customer3 = Customer.builder()
                    .name("Marek")
                    .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8ef"))
                    .age(22)
                    .pesel("51022797418")
                    .surname("Markowski")
                    .build();

            customerServiceJPA.saveNewCustomer(customer);
            customerServiceJPA.saveNewCustomer(customer1);
            customerServiceJPA.saveNewCustomer(customer2);
            customerServiceJPA.saveNewCustomer(customer3);
        }
    }

}
