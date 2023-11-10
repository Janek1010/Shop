package com.example.shop.order.mappers;

import com.example.shop.customer.entities.Customer;
import com.example.shop.order.entity.Order;
import com.example.shop.order.model.GetOrderResponse;
import com.example.shop.order.model.PutOrderRequest;
import com.example.shop.order.model.dto.OrderDTO;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper
public interface OrderMapper {
    default OrderDTO orderToOrderDto(Order order){
        if (order == null) {
            return null;
        }
        return OrderDTO.builder()
                .id(order.getId())
                .productName(order.getProductName())
                .quantity(order.getQuantity())
                .customer( order.getCustomer().getId())
                .build();
    }
    default GetOrderResponse orderToGetOrderResponse(Order order){
        if (order == null) {
            return null;
        }
        return GetOrderResponse.builder()
                .id(order.getId())
                .productName(order.getProductName())
                .quantity(order.getQuantity())
                .customer( order.getCustomer().getId())
                .build();
    }
    default Order putOrderRequestToOrder(UUID uuid, PutOrderRequest putOrderRequest) {
        if (putOrderRequest == null) {
            return null;
        }
        return Order.builder()
                .id(uuid)
                .productName(putOrderRequest.getProductName())
                .quantity(putOrderRequest.getQuantity())
                .customer(Customer.builder()
                        .id(putOrderRequest.getCustomer())
                        .build())
                .build();
    }
}
