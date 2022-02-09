package com.example.getirreadingisgood.order.exception;

public class InvalidDatesException extends OrderException {
    public InvalidDatesException() {
        super("End date should be earlier than the start date");
    }
}
