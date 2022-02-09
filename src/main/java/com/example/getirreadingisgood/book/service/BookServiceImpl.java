package com.example.getirreadingisgood.book.service;

import com.example.getirreadingisgood.book.entity.Book;
import com.example.getirreadingisgood.book.exception.BookDoesNotExistException;
import com.example.getirreadingisgood.book.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public UUID registerBook(Book newBook) {
        setBookIdAndRestockDate(newBook);
        bookRepository.save(newBook);

        UUID bookId = newBook.getBookId();
        log.info("Book registered with id: " + bookId);

        return bookId;
    }

    private void setBookIdAndRestockDate(Book newBook) {
        newBook.setBookId(UUID.randomUUID());
        newBook.setLastRestockTime(LocalDateTime.now());
    }

    @Override
    @Transactional
    public int restock(UUID bookId, int additionalStock) {
        Optional<Book> book = bookRepository.findBookByBookId(bookId);

        if (book.isEmpty()) {
            throw new BookDoesNotExistException();
        }

        int newStock = book.get().getStock() + additionalStock;
        book.get().setStock(newStock);
        book.get().setLastRestockTime(LocalDateTime.now());
        bookRepository.save(book.get());

        return newStock;
    }

    @Override
    public int getBookStock(UUID bookId) {
        Optional<Book> book = bookRepository.findBookByBookId(bookId);

        if (book.isEmpty()) {
            throw new BookDoesNotExistException();
        }

        return book.get().getStock();
    }

    @Override
    public void updateStocks(List<UUID> orderedBooks) {
        orderedBooks.forEach((bookId) -> {
            Optional<Book> book = bookRepository.findBookByBookId(bookId);
            if (book.isEmpty()) {
                throw new BookDoesNotExistException();
            }

            Book existingBook = book.get();
            existingBook.setStock(existingBook.getStock() - 1);
            bookRepository.save(existingBook);
        });
    }

}
