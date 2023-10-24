package com.example.shop.order.service.api;

import com.example.shop.order.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface OrderService {
    void saveNewOrder(Order order);
    List<Order> findAllOrders();
    List<Order> findByCustomerName(String customerName);
    Optional<Order> findOrderById(UUID uuid);
    void deleteOrderById(UUID uuid);
    Optional<Order> findByCustomer_Pesel(String pesel);
}
