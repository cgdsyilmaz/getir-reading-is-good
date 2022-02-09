package com.example.getirreadingisgood.order.exception;

import com.example.getirreadingisgood.order.entity.Order;

public class OrderDoesNotExistException extends OrderException {
    public OrderDoesNotExistException() {
        super("Order with the given id does not exist.");
    }
}
