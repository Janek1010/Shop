package com.example.shop.customer.entities;

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

    @Column(name = "pesel",unique = true)
    private String pesel;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

}