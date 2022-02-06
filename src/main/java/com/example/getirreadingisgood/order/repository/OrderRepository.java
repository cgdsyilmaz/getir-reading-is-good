package com.example.getirreadingisgood.order.repository;

import com.example.getirreadingisgood.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<Order, UUID> {
}
