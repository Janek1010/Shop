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
public class PutOrderRequest {
    private String productName;
    private Integer quantity;
    private UUID customer;
}
