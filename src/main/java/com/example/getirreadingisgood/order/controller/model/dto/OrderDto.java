package com.example.getirreadingisgood.order.controller.model.dto;

import com.example.getirreadingisgood.util.EntityConstraints;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class OrderDto {
    @NotNull(message = EntityConstraints.ORDER_WITHOUT_CUSTOMER_MESSAGE)
    private UUID customerId;
    @NotEmpty(message = EntityConstraints.ORDER_HAS_NO_ITEMS)
    private List<UUID> books;
    @Min(value = EntityConstraints.MINIMUM_VALUE)
    private double total;
}
