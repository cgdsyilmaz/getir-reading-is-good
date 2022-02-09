package com.example.getirreadingisgood.book.controller.model.request;

import com.example.getirreadingisgood.util.EntityConstraints;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class RestockRequest {
    @Min(value = EntityConstraints.MINIMUM_ADDITIONAL_STOCK)
    private int additionalStock;
}
