package com.example.getirreadingisgood.statistics.repository;

import com.example.getirreadingisgood.statistics.entity.Statistics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StatisticsRepository extends MongoRepository<Statistics, UUID> {
    List<Statistics> findStatisticsByCustomerId(UUID customerId);
    Optional<Statistics> findStatisticsByCustomerIdAndMonth(UUID customerId, Month month);
}
