package com.example.getirreadingisgood.order.service;

import com.example.getirreadingisgood.order.entity.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<Order> getOrdersOfCustomer(UUID customerId, int page, int size);
    UUID enterOrder(Order newOrder);
    Order getOrderById(UUID orderId);
    List<Order> getOrdersBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
}
