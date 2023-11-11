package com.example.shop.customer.event.repository.api;

import com.example.shop.customer.entities.Customer;

import java.util.UUID;

public interface CustomerEventRepository {
    void delete(UUID uuid);
    void create(UUID uuid);
}
