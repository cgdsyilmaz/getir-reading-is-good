package com.example.getirreadingisgood.book.controller.mapper;

import com.example.getirreadingisgood.book.controller.model.dto.BookDto;
import com.example.getirreadingisgood.book.entity.Book;
import org.modelmapper.ModelMapper;

public class BookMapper {
    public static Book mapBookDtoToBook(BookDto bookDto, ModelMapper modelMapper) {
        return modelMapper.map(bookDto, Book.class);
    }
}
