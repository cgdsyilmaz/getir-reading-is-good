package com.example.getirreadingisgood.book.service;

import com.example.getirreadingisgood.book.entity.Book;
import com.example.getirreadingisgood.book.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    @Mock
    private BookRepository bookRepository;
    private BookService bookService;


    @BeforeEach
    void setUp() {
        bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    void restockBookTest() {
        Book book = Book.builder()
                .bookId(UUID.randomUUID())
                .title("Lotr")
                .authors(List.of("Tolkien"))
                .lastRestockTime(LocalDateTime.now())
                .price(10)
                .stock(10)
                .build();

        int expectedStock = 110;

        when(bookRepository.findBookByBookId(book.getBookId())).thenReturn(Optional.of(book));
        int newStock = bookService.restock(book.getBookId(), 100);

        assertEquals(expectedStock, newStock);
    }
}