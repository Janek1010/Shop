package com.example.shop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/**
 * TO JEST KATEGORIA
 */

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer implements Comparable<Customer>{

    @Id
    //@GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
    private int age;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;

        if (getAge() != customer.getAge()) return false;
        if (getId() != null ? !getId().equals(customer.getId()) : customer.getId() != null) return false;
        return getName() != null ? getName().equals(customer.getName()) : customer.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getAge();
        return result;
    }

    @Override
    public int compareTo(Customer otherCustomer) {
        return Comparator.comparing(Customer::getName)
                .thenComparing(Customer::getAge)
                .compare(this,otherCustomer);
    }
}