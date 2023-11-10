package com.example.shop.customer.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutCustomerRequest {
    private String pesel;
    private String name;
    private String surname;
    private int age;
}
