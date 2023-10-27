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
@EqualsAndHashCode
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "pesel",unique = true)
    private String pesel;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Order> orders;

}