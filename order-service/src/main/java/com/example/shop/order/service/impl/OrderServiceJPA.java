package com.example.shop.order.service.impl;

import com.example.shop.order.entity.Order;
import com.example.shop.order.repository.OrderRepository;
import com.example.shop.order.service.api.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class OrderServiceJPA implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> findOrdersByCustomer_Id(UUID uuid) {
        return orderRepository.findByCustomer_Id(uuid);
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByCustomerName(String customerName) {
        return orderRepository.findByCustomer_Name(customerName);
    }

    @Override
    public Optional<Order> findOrderById(UUID uuid) {
        return orderRepository.findById(uuid);
    }


    @Override
    public void deleteOrderById(UUID uuid) {
        orderRepository.deleteById(uuid);
    }

    @Override
    public List<Order> findByCustomer_Pesel(String pesel) {
        return orderRepository.findByCustomer_Pesel(pesel);
    }


}
