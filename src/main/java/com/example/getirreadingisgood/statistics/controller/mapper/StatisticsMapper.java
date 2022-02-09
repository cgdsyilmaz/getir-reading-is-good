package com.example.getirreadingisgood.statistics.controller.mapper;

import com.example.getirreadingisgood.statistics.controller.model.StatisticsResponse;
import com.example.getirreadingisgood.statistics.entity.Statistics;
import org.modelmapper.ModelMapper;

public class StatisticsMapper {
    public static StatisticsResponse mapStatisticsToStatisticsResponse(Statistics statistics, ModelMapper modelMapper) {
        return modelMapper.map(statistics, StatisticsResponse.class);
    }
}
