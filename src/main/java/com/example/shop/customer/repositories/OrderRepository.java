package com.example.shop.customer.repositories;

import com.example.shop.customer.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findByCustomer_Name(String customerName);
    Optional<Order> findByCustomer_Pesel(String pesel);

}
