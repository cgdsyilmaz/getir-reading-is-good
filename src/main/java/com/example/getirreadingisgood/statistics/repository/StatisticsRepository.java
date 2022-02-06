package com.example.getirreadingisgood.statistics.repository;

import com.example.getirreadingisgood.statistics.entity.Statistics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StatisticsRepository extends MongoRepository<Statistics, UUID> {
}
