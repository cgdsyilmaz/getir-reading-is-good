package com.example.getirreadingisgood.order.controller;

import com.example.getirreadingisgood.order.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
}
