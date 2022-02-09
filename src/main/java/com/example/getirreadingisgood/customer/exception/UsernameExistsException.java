package com.example.getirreadingisgood.customer.exception;

public class UsernameExistsException extends CustomerException {
    public UsernameExistsException() {
        super("Username is already taken.");
    }
}
