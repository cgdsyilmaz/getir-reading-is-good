package com.example.getirreadingisgood.statistics.entity;

import com.example.getirreadingisgood.util.EntityConstraints;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.Month;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "statistics")
public class Statistics {
    @Id
    private UUID statisticsId;

    @NotBlank(message = EntityConstraints.STATISTICS_WITHOUT_CUSTOMER_MESSAGE)
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
