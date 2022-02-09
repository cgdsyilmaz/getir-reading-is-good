package com.example.getirreadingisgood.order.controller.model.request;

import com.example.getirreadingisgood.util.EntityConstraints;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class OrderRequestBetweenDates {
    @NotNull(message = EntityConstraints.START_DATE_NULL_MESSAGE)
    private LocalDateTime startDate;
    @NotNull(message = EntityConstraints.END_DATE_NULL_MESSAGE)
    private LocalDateTime endDate;
}
