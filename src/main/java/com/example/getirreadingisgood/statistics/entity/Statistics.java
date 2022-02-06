package com.example.getirreadingisgood.statistics.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Builder
@Data
@Document(collection = "statistics")
public class Statistics {
    @Id
    private UUID statisticsId;

    @NotNull(message = "Customer cannot be null.")
    private UUID customerId;

    @Indexed(unique = true)
    private int month;

    @Min(value = 0)
    private int orderCount;
    @Min(value = 0)
    private int bookCount;

    @Min(value = 0)
    private double totalInMonth;

}
