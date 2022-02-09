package com.example.getirreadingisgood.order.controller.mapper;

import com.example.getirreadingisgood.order.controller.model.dto.OrderDto;
import com.example.getirreadingisgood.order.controller.model.response.OrderResponse;
import com.example.getirreadingisgood.order.entity.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class OrderMapperTest {
    private ModelMapper modelMapper;

    @BeforeEach
    void setup() {
        modelMapper = new ModelMapper();
    }

    @Test
    void checkFieldEqualityAfterDtoConversion() {
        OrderDto orderDto = OrderDto.builder()
                .customerId(UUID.randomUUID())
                .books(List.of(UUID.randomUUID(), UUID.randomUUID()))
                .total(100)
                .build();

        Order order = OrderMapper.mapOrderDtoToOrder(orderDto, modelMapper);

        assertEquals(orderDto.getCustomerId(), order.getCustomerId());
        assertIterableEquals(orderDto.getBooks(), order.getBooks());
        assertEquals(orderDto.getTotal(), orderDto.getTotal());
    }

    @Test
    void checkFieldEqualityAfterEntityConversion() {
        Order order = Order.builder()
                .books(List.of(UUID.randomUUID(), UUID.randomUUID()))
                .orderDate(LocalDateTime.now())
                .total(500)
                .customerId(UUID.randomUUID())
                .orderId(UUID.randomUUID())
                .build();

        OrderResponse orderResponse = OrderMapper.mapOrderToOrderResponse(order, modelMapper);

        assertIterableEquals(order.getBooks(), orderResponse.getBooks());
        assertEquals(order.getOrderDate(), orderResponse.getOrderDate());
        assertEquals(order.getTotal(), orderResponse.getTotal());
    }

}