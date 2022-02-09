package com.example.getirreadingisgood.order.service;

import com.example.getirreadingisgood.book.service.BookService;
import com.example.getirreadingisgood.order.entity.Order;
import com.example.getirreadingisgood.order.exception.InvalidDatesException;
import com.example.getirreadingisgood.order.exception.OrderDoesNotExistException;
import com.example.getirreadingisgood.order.exception.UnsatisfiableOrderException;
import com.example.getirreadingisgood.order.repository.OrderRepository;
import com.example.getirreadingisgood.statistics.service.StatisticsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private BookService bookService;
    @Mock
    private StatisticsService statisticsService;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderServiceImpl(orderRepository, bookService, statisticsService);
    }

    @Test
    void testOrderIsSatisfiableThrows() {
        UUID bookId = UUID.randomUUID();
        when(bookService.getBookStock(bookId)).thenReturn(-1);
        assertThrows(UnsatisfiableOrderException.class, () -> {
            orderService.enterOrder(Order.builder().books(List.of(bookId)).build());
        });
    }

    @Test
    void testOrderByIdThrows() {
        UUID orderId = UUID.randomUUID();
        when(orderRepository.findOrderByOrderId(orderId)).thenReturn(Optional.empty());
        assertThrows(OrderDoesNotExistException.class, () -> {
           orderService.getOrderById(orderId);
        });
    }

    @Test
    void testValidateOrdersThrows() {
        LocalDateTime startDate = LocalDateTime.of(2022,5, 1, 1, 0);
        LocalDateTime endDate = LocalDateTime.of(2022,4, 1, 1, 0);
        assertThrows(InvalidDatesException.class, () -> {
            orderService.getOrdersBetweenDates(startDate, endDate);
        });
    }
}