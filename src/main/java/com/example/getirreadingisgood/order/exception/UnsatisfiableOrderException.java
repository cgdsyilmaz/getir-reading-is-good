package com.example.getirreadingisgood.order.exception;

import java.util.UUID;

public class UnsatisfiableOrderException extends OrderException {
    public UnsatisfiableOrderException(UUID bookId) {
        super("Order cannot be satisfied to the customer because there is not enough stock for book with id: "
                + bookId);
    }
}
