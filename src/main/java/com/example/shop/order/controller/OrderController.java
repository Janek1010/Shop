package com.example.shop.order.controller;

import com.example.shop.customer.model.GetCustomersResponse;
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
    public final String ORDER_PATH_ID = ORDER_PATH +"/{orderId}";
    private final OrderMapper orderMapper;
    private final OrderService orderService;


    @GetMapping(ORDER_PATH)
    public ResponseEntity<GetOrdersResponse> getOrders(){
       return ResponseEntity.ok(GetOrdersResponse.builder().orders(orderService.findAllOrders().stream().map(orderMapper::orderToOrderDto).toList()).build());
    }
    @GetMapping(ORDER_PATH_ID)
    public ResponseEntity<GetOrderResponse> getOrder(@PathVariable("orderId") UUID uuid){
        return ResponseEntity.ok(orderService.findOrderById(uuid).map(orderMapper::orderToGetOrderResponse).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
    @PutMapping(ORDER_PATH_ID)
    public ResponseEntity putOrder(@PathVariable("orderId") UUID uuid, @RequestBody PutOrderRequest request){
        orderService.saveOrder(orderMapper.putOrderRequestToOrder(uuid, request));
        return ResponseEntity.ok().build();
    }
}

