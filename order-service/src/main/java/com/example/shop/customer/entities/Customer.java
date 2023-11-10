package com.example.shop.customer.entities;

import com.example.shop.order.entity.Order;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.*;

/**
 * TO JEST KATEGORIA
 */

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @Column(name = "id")
    private UUID id;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Order> orders;

}