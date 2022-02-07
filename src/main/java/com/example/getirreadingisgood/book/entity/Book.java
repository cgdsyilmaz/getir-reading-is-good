package com.example.getirreadingisgood.book.entity;

import com.example.getirreadingisgood.util.EntityConstraints;
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

    @NotBlank(message = EntityConstraints.TITLE_BLANK_MESSAGE)
    private String title;
    @NotBlank(message = EntityConstraints.AUTHOR_NAME_BLANK_MESSAGE)
    private List<String> authors;

    @Min(value = EntityConstraints.MINIMUM_VALUE)
    private int stock;
    @Min(value = EntityConstraints.MINIMUM_VALUE)
    private double price;

    private LocalDateTime lastRestockTime;


}
