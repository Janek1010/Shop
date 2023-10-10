package com.example.shop.entities;

import jakarta.persistence.*;
import lombok.*;

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
public class Customer implements Comparable<Customer>{

    @Id
    //@GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
    private int age;

    @Builder.Default
    @OneToMany(mappedBy = "customer")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Order> orders = new HashSet<>();


    @Override
    public int compareTo(Customer otherCustomer) {
        return Comparator.comparing(Customer::getName)
                .thenComparing(Customer::getAge)
                .compare(this,otherCustomer);
    }
}