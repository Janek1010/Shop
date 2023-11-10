package com.example.shop.order.entity;

import com.example.shop.customer.entities.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;
/**
 * TO JEST ELEMENT
 */
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "orders")
public class Order implements Serializable {


    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;


}
