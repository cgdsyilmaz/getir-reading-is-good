package com.example.getirreadingisgood.order.service;

import com.example.getirreadingisgood.book.service.BookService;
import com.example.getirreadingisgood.order.entity.Order;
import com.example.getirreadingisgood.order.exception.InvalidDatesException;
import com.example.getirreadingisgood.order.exception.OrderDoesNotExistException;
import com.example.getirreadingisgood.order.exception.UnsatisfiableOrderException;
import com.example.getirreadingisgood.order.repository.OrderRepository;
import com.example.getirreadingisgood.statistics.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final BookService bookService;
    private final StatisticsService statisticsService;

    public OrderServiceImpl(OrderRepository orderRepository, BookService bookService, StatisticsService statisticsService) {
        this.orderRepository = orderRepository;
        this.bookService = bookService;
        this.statisticsService = statisticsService;
    }

    @Override
    public List<Order> getOrdersOfCustomer(UUID customerId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepository.findOrderByCustomerId(customerId, pageable);
    }

    @Override
    @Transactional
    public UUID enterOrder(Order newOrder) {
        List<UUID> orderedBooks = newOrder.getBooks();
        checkIfOrderIsSatisfiable(orderedBooks);

        setOrderIdAndDate(newOrder);
        orderRepository.save(newOrder);

        updateStocks(orderedBooks);
        updateStatistics(newOrder);

        UUID orderId = newOrder.getOrderId();
        log.info("Order entered with id: " + orderId);

        return orderId;
    }

    private void checkIfOrderIsSatisfiable(List<UUID> books) {
        books.forEach((bookId) -> {
            int bookStock = bookService.getBookStock(bookId);
            if (bookStock <= 0) {
                throw new UnsatisfiableOrderException(bookId);
            }
        });
    }

    private void setOrderIdAndDate(Order newOrder) {
        newOrder.setOrderId(UUID.randomUUID());
        newOrder.setOrderDate(LocalDateTime.now());
    }

    private void updateStocks(List<UUID> orderedBooks) {
        bookService.updateStocks(orderedBooks);
    }

    private void updateStatistics(Order order) {
        statisticsService.updateStatistics(order);
    }

    @Override
    public Order getOrderById(UUID orderId) {
        Optional<Order> order = orderRepository.findOrderByOrderId(orderId);
        if (order.isEmpty()) {
            throw new OrderDoesNotExistException();
        }

        return order.get();
    }

    @Override
    public List<Order> getOrdersBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        validateDates(startDate, endDate);
        return orderRepository.findOrderByOrderDateBetween(startDate, endDate);
    }

    private void validateDates(LocalDateTime startDate, LocalDateTime endDate) {
        if (endDate.isBefore(startDate)) {
            throw new InvalidDatesException();
        }
    }
}
