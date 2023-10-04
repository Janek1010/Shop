package com.example.shop.services;

import com.example.shop.entities.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order saveNewOrder(Order order);
    List<Order> findAllOrders();
    List<Order> findByCustomerName(String customerName);
}
