package com.example.services;

import com.example.entities.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order saveNewOrder(Order order);
    List<Order> findAllOrders();
}
