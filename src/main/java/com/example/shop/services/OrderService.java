package com.example.shop.services;

import com.example.shop.entities.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface OrderService {
    Order saveNewOrder(Order order);
    List<Order> findAllOrders();
    List<Order> findByCustomerName(String customerName);
    Boolean existsById(UUID uuid);
    void deleteOrderById(UUID uuid);
}
