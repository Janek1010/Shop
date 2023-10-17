package com.example.shop.customer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
/**
 * TO JEST ELEMENT
 */
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "orders")
public class Order{

    public Order(UUID id, String productName, Integer quantity, Customer customer) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.setCustomer(customer);
    }

    @Id
    //@GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.getOrders().add(this);
    }

}
