package com.example.getirreadingisgood.order.controller.model.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class OrderResponse {
    private List<UUID> books;
    private LocalDateTime orderDate;
    private double total;
}
