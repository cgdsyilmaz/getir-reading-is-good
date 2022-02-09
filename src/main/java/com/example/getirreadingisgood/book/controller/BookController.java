package com.example.getirreadingisgood.book.controller;

import com.example.getirreadingisgood.book.controller.mapper.BookMapper;
import com.example.getirreadingisgood.book.controller.model.dto.BookDto;
import com.example.getirreadingisgood.book.controller.model.request.RestockRequest;
import com.example.getirreadingisgood.book.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final ModelMapper modelMapper;

    public BookController(BookService bookService, ModelMapper modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UUID> registerBook(@RequestBody @Valid BookDto bookDto) {
        UUID bookId = bookService.registerBook(BookMapper.mapBookDtoToBook(bookDto, modelMapper));
        return ResponseEntity.ok().body(bookId);
    }

    @PutMapping("/restock/{bookId}")
    public ResponseEntity<Integer> restockBook(@PathVariable UUID bookId, @RequestBody @Valid RestockRequest additionalStockRequest) {
        int totalStock = bookService.restock(bookId, additionalStockRequest.getAdditionalStock());
        return ResponseEntity.ok().body(totalStock);
    }
}
