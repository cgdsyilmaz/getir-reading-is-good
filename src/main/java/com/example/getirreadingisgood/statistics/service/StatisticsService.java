package com.example.getirreadingisgood.statistics.service;

import com.example.getirreadingisgood.statistics.repository.StatisticsRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {
    private final StatisticsRepository statisticsRepository;

    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }
}
