package com.example.getirreadingisgood.book.service;

import com.example.getirreadingisgood.book.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    UUID registerBook(Book newBook);
    int restock(UUID bookId, int additionalStock);
    int getBookStock(UUID bookId);
    void updateStocks(List<UUID> orderedBooks);
}
