package com.example.getirreadingisgood.statistics.entity;

import com.example.getirreadingisgood.util.EntityConstraints;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Month;
import java.util.UUID;

@Builder
@Data
@Document(collection = "statistics")
public class Statistics {
    @Id
    private UUID statisticsId;

    @NotNull(message = EntityConstraints.STATISTICS_WITHOUT_CUSTOMER_MESSAGE)
    private UUID customerId;

    @Indexed(unique = true)
    private Month month;

    @Min(value = EntityConstraints.MINIMUM_VALUE)
    private int orderCount;
    @Min(value = EntityConstraints.MINIMUM_VALUE)
    private int bookCount;

    @Min(value = EntityConstraints.MINIMUM_VALUE)
    private double totalInMonth;

}
