package com.example.getirreadingisgood.statistics.controller.model;

import lombok.Data;

import java.time.Month;

@Data
public class StatisticsResponse {
    private Month month;
    private int orderCount;
    private int bookCount;
    private double totalInMonth;
}
