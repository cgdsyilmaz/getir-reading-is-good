package com.example.getirreadingisgood.statistics.controller;

import com.example.getirreadingisgood.statistics.controller.mapper.StatisticsMapper;
import com.example.getirreadingisgood.statistics.controller.model.StatisticsResponse;
import com.example.getirreadingisgood.statistics.entity.Statistics;
import com.example.getirreadingisgood.statistics.service.StatisticsServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    private final StatisticsServiceImpl statisticsService;
    private final ModelMapper modelMapper;

    public StatisticsController(StatisticsServiceImpl statisticsService, ModelMapper modelMapper) {
        this.statisticsService = statisticsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<StatisticsResponse>> getMonthlyStatisticsOfCustomer(@PathVariable UUID customerId) {
        List<Statistics> monthlyStatisticsOfCustomer = statisticsService.getMonthlyStatisticsOfCustomer(customerId);
        List<StatisticsResponse> customerStatistics = monthlyStatisticsOfCustomer.stream()
                .map(statistics -> StatisticsMapper.mapStatisticsToStatisticsResponse(statistics, modelMapper))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(customerStatistics);
    }
}
