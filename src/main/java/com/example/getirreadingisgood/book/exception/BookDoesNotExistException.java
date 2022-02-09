package com.example.getirreadingisgood.book.exception;

public class BookDoesNotExistException extends BookException {
    public BookDoesNotExistException() {
        super("Book with the given id does not exist.");
    }
}
