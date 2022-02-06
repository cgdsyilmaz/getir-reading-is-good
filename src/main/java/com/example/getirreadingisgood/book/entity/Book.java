package com.example.getirreadingisgood.book.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@Document(collection = "books")
public class Book {

    @Id
    private UUID bookId;

    @NotBlank(message = "Title cannot be empty.")
    private String title;
    @NotBlank(message = "Authors cannot be empty.")
    private List<String> authors;

    @Min(value = 0)
    private int stock;
    @Min(value = 0)
    private double price;

    private LocalDateTime lastRestockTime;


}
