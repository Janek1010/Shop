package com.example.shop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Comparator;
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
public class Order implements Comparable<Order>{

    public Order(UUID id, String productName, Integer quantity, Customer customer) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.setCustomer(customer);
    }

    @Id
    //@GeneratedValue(generator = "UUID")
    private UUID id;

    private String productName;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.getOrders().add(this);
    }

    @Override
    public int compareTo(Order otherOrder) {
        return Comparator.comparing(Order::getProductName)
                .thenComparing(Order::getQuantity)
                .compare(this,otherOrder);
    }

}
