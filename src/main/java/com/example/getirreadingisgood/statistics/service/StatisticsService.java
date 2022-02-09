package com.example.getirreadingisgood.statistics.service;

import com.example.getirreadingisgood.order.entity.Order;
import com.example.getirreadingisgood.statistics.entity.Statistics;

import java.util.List;
import java.util.UUID;

public interface StatisticsService {
    List<Statistics> getMonthlyStatisticsOfCustomer(UUID customerId);
    void updateStatistics(Order order);
}
