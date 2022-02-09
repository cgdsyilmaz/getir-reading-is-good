package com.example.getirreadingisgood.statistics.controller.mapper;

import com.example.getirreadingisgood.statistics.controller.model.StatisticsResponse;
import com.example.getirreadingisgood.statistics.entity.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.Month;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticsMapperTest {
    private ModelMapper modelMapper;

    @BeforeEach
    void setup() {
        modelMapper = new ModelMapper();
    }

    @Test
    void checkFieldEqualityAfterStatisticsConversion() {
        Statistics statistics = Statistics.builder()
                .statisticsId(UUID.randomUUID())
                .customerId(UUID.randomUUID())
                .month(Month.JANUARY)
                .orderCount(2)
                .bookCount(5)
                .totalInMonth(100)
                .build();

        StatisticsResponse statisticsResponse = StatisticsMapper.mapStatisticsToStatisticsResponse(statistics, modelMapper);

        assertEquals(statistics.getMonth(), statisticsResponse.getMonth());
        assertEquals(statistics.getOrderCount(), statisticsResponse.getOrderCount());
        assertEquals(statistics.getBookCount(), statisticsResponse.getBookCount());
        assertEquals(statistics.getTotalInMonth(), statistics.getTotalInMonth());
    }
}