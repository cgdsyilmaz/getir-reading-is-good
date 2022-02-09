package com.example.getirreadingisgood.statistics.exception;

public class StatisticsDoesNotExist extends StatisticsException {
    public StatisticsDoesNotExist() {
        super("No statistic info exist for given user and given month.");
    }
}
