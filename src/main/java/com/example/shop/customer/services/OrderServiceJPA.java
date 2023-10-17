package com.example.shop.customer.services;

import com.example.shop.customer.entities.Order;
import com.example.shop.customer.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class OrderServiceJPA implements OrderService{
    private final OrderRepository orderRepository;

    @Override
    public Order saveNewOrder(Order order) {
        return orderRepository.save(order);
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
    public Boolean existsById(UUID uuid) {
        return orderRepository.existsById(uuid);
    }

    @Override
    public void deleteOrderById(UUID uuid) {
        orderRepository.deleteById(uuid);
    }

    @Override
    public Optional<Order> findByCustomer_Pesel(String pesel) {
        return orderRepository.findByCustomer_Pesel(pesel);
    }

}
