package com.example.getirreadingisgood.order.repository;

import com.example.getirreadingisgood.order.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<Order, UUID> {
    Optional<Order> findOrderByOrderId(UUID orderId);
    List<Order> findOrderByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Order> findOrderByCustomerId(UUID customerId, Pageable pageable);
}
