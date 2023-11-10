package com.example.shop.order.controller;

import com.example.shop.order.mappers.OrderMapper;
import com.example.shop.order.model.GetOrderResponse;
import com.example.shop.order.model.GetOrdersResponse;
import com.example.shop.order.model.PutOrderRequest;
import com.example.shop.order.service.api.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class OrderController {
    public final String ORDER_PATH = "/api/orders";
    public final String ORDER_PATH_ID = ORDER_PATH + "/{orderId}";
    private final OrderMapper orderMapper;
    private final OrderService orderService;


    @GetMapping("/api/customers/{customerId}/orders")
    public ResponseEntity<GetOrdersResponse> getOrdersOfCustomer(@PathVariable("customerId") UUID uuid) {
        return ResponseEntity.ok(GetOrdersResponse.builder().orders(orderService.findOrdersByCustomer_Id(uuid).stream().map(orderMapper::orderToOrderDto).toList()).build());
    }

    @GetMapping(ORDER_PATH)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetOrdersResponse getOrders() {
        return GetOrdersResponse.builder().orders(orderService.findAllOrders().stream().map(orderMapper::orderToOrderDto).toList()).build();
    }

    @GetMapping(ORDER_PATH_ID)
    public ResponseEntity<GetOrderResponse> getOrder(@PathVariable("orderId") UUID uuid) {
        return ResponseEntity.ok(orderService.findOrderById(uuid).map(orderMapper::orderToGetOrderResponse).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @PutMapping(ORDER_PATH_ID)
    public ResponseEntity<Void> putOrder(@PathVariable("orderId") UUID uuid, @RequestBody PutOrderRequest request) {
        orderService.saveOrder(orderMapper.putOrderRequestToOrder(uuid, request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(ORDER_PATH_ID)
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") UUID uuid) {
        orderService.deleteOrderById(uuid);
        return ResponseEntity.noContent().build();
    }
}

