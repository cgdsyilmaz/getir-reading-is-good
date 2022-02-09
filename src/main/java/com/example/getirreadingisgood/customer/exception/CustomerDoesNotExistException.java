package com.example.getirreadingisgood.customer.exception;

public class CustomerDoesNotExistException extends CustomerException {
    public CustomerDoesNotExistException() {
        super("Customer does not exist.");
    }
}
