package com.example.getirreadingisgood.book.controller.mapper;

import com.example.getirreadingisgood.book.controller.model.dto.BookDto;
import com.example.getirreadingisgood.book.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {
    private ModelMapper modelMapper;

    @BeforeEach
    void setup() {
        modelMapper = new ModelMapper();
    }

    @Test
    void checkFieldEqualityAfterConversion() {
        BookDto bookDto = BookDto.builder()
                .authors(Arrays.asList("Cagdas", "Idil"))
                .price(55.2)
                .stock(100)
                .title("BookTitle")
                .build();

        Book book = BookMapper.mapBookDtoToBook(bookDto, modelMapper);

        assertIterableEquals(bookDto.getAuthors(), book.getAuthors());
        assertEquals(bookDto.getPrice(), book.getPrice());
        assertEquals(bookDto.getStock(), book.getStock());
        assertEquals(bookDto.getTitle(), book.getTitle());
    }
}