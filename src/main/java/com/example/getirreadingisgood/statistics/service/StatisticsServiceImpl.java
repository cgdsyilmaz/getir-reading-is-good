package com.example.getirreadingisgood.statistics.service;

import com.example.getirreadingisgood.order.entity.Order;
import com.example.getirreadingisgood.statistics.entity.Statistics;
import com.example.getirreadingisgood.statistics.exception.StatisticsDoesNotExist;
import com.example.getirreadingisgood.statistics.repository.StatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    private final StatisticsRepository statisticsRepository;

    public StatisticsServiceImpl(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public List<Statistics> getMonthlyStatisticsOfCustomer(UUID customerId) {
        List<Statistics> statistics = statisticsRepository.findStatisticsByCustomerId(customerId);

        if (statistics.isEmpty()) {
            throw new StatisticsDoesNotExist();
        }

        return statistics;
    }

    @Override
    public void updateStatistics(Order order) {
        Optional<Statistics> monthlyStatistics = statisticsRepository.
                findStatisticsByCustomerIdAndMonth(order.getCustomerId(), order.getOrderDate().getMonth());

        if (monthlyStatistics.isEmpty()) {
            Statistics newStatistics = Statistics.builder()
                    .statisticsId(UUID.randomUUID())
                    .customerId(order.getCustomerId())
                    .month(order.getOrderDate().getMonth())
                    .orderCount(1)
                    .bookCount(order.getBooks().size())
                    .totalInMonth(order.getTotal())
                    .build();
            statisticsRepository.save(newStatistics);
        } else {
            Statistics currentMonthlyStatistics = monthlyStatistics.get();
            currentMonthlyStatistics.setOrderCount(currentMonthlyStatistics.getOrderCount() + 1);
            currentMonthlyStatistics.setBookCount(currentMonthlyStatistics.getBookCount() + order.getBooks().size());
            currentMonthlyStatistics.setTotalInMonth(currentMonthlyStatistics.getTotalInMonth() + order.getTotal());
            statisticsRepository.save(currentMonthlyStatistics);
        }
    }
}