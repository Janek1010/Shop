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
@Table(name = "orders")
public class Order{
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;


    private String productName;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private Customer customer;

//    @Override
//    public String toString() {
//        return "Order{" +
//                "id=" + id +
//                ", productName='" + productName + '\'' +
//                ", quantity=" + quantity +
//                ", customer=" + customer.getName() +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Order order)) return false;
//
//        if (getId() != null ? !getId().equals(order.getId()) : order.getId() != null) return false;
//        if (getProductName() != null ? !getProductName().equals(order.getProductName()) : order.getProductName() != null)
//            return false;
//        if (getQuantity() != null ? !getQuantity().equals(order.getQuantity()) : order.getQuantity() != null)
//            return false;
//        return getCustomer() != null ? getCustomer().equals(order.getCustomer()) : order.getCustomer() == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getId() != null ? getId().hashCode() : 0;
//        result = 31 * result + (getProductName() != null ? getProductName().hashCode() : 0);
//        result = 31 * result + (getQuantity() != null ? getQuantity().hashCode() : 0);
//        result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
//        return result;
//    }
//
//    @Override
//    public int compareTo(Order otherOrder) {
//        return Comparator.comparing(Order::getProductName)
//                .thenComparing(Order::getQuantity)
//                .compare(this,otherOrder);
//    }

}
