package com.example.shop.customer.entities;

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
public class Customer{

    @Id
    //@GeneratedValue(generator = "UUID")
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

    @Builder.Default
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Order> orders = new ArrayList<>();

}