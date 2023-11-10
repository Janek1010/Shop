package com.example.shop.order.model;

import com.example.shop.customer.model.dto.CustomerDTO;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetOrderResponse {
    private UUID id;
    private String productName;
    private Integer quantity;
    private CustomerDTO customer;
}
