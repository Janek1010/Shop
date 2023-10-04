package com.example.shop.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Builder
@Data
public class OrderDTO implements Serializable {
    private UUID id;
    private Integer version;

    private String productName;
    private Integer quantity;
    private String customer;
}
