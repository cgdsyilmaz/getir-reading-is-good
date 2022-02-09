package com.example.getirreadingisgood.customer.exception;

public class EmailExistsException extends CustomerException {
    public EmailExistsException() {
        super("This email has already been used.");
    }
}
