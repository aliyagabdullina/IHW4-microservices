package com.example.restaurant;

import model.Order;
import org.springframework.web.bind.annotation.*;
import services.OrderService;

@RestController
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/order")
    public Order makeOrder(@RequestBody Order orderDto) {
        return service.makeOrder(orderDto);
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable("id") Integer orderId) {
        return service.getOrder(orderId);
    }
}