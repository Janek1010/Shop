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
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "orders")
public class Order implements Comparable<Order>{
    @Id
    //@GeneratedValue(generator = "UUID")
    private UUID id;

    private String productName;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @Override
    public int compareTo(Order otherOrder) {
        return Comparator.comparing(Order::getProductName)
                .thenComparing(Order::getQuantity)
                .compare(this,otherOrder);
    }

}
