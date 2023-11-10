package com.example.shop.order.model.dto;

import com.example.shop.customer.entities.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class OrderDTO {
    private UUID id;
    private String productName;
    private Integer quantity;
    private Customer customer;
}
