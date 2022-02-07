package com.example.getirreadingisgood.order.entity;

import com.example.getirreadingisgood.util.EntityConstraints;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@Document(collection = "orders")
public class Order {
    @Id
    private UUID orderId;
    @NotNull(message = EntityConstraints.ORDER_WITHOUT_CUSTOMER_MESSAGE)
    private UUID customerId;

    private List<UUID> items;
    private LocalDateTime orderDate;

    @Min(value = EntityConstraints.MINIMUM_VALUE)
    private double total;
}
