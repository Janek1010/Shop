package com.example.shop.order.mappers;

import com.example.shop.customer.entities.Customer;
import com.example.shop.customer.model.GetCustomerResponse;
import com.example.shop.customer.model.PutCustomerRequest;
import com.example.shop.customer.model.dto.CustomerDTO;
import com.example.shop.order.entity.Order;
import com.example.shop.order.model.GetOrderResponse;
import com.example.shop.order.model.PutOrderRequest;
import com.example.shop.order.model.dto.OrderDTO;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper
public interface OrderMapper {
    Order orderDtoToOrder(OrderDTO orderDTO);
    OrderDTO orderToOrderDto(Order order);
    GetOrderResponse orderToGetOrderResponse(Order order);
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
