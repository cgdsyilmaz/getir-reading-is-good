package com.example.getirreadingisgood.book.controller.model.dto;

import com.example.getirreadingisgood.util.EntityConstraints;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
public class BookDto {
    @NotBlank(message = EntityConstraints.TITLE_BLANK_MESSAGE)
    private String title;
    @NotEmpty(message = EntityConstraints.AUTHOR_NAME_BLANK_MESSAGE)
    private List<String> authors;
    @Min(value = EntityConstraints.MINIMUM_VALUE)
    private int stock;
    @Min(value = EntityConstraints.MINIMUM_VALUE)
    private double price;
}
