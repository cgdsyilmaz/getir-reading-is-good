package com.example.getirreadingisgood.order.controller;

import com.example.getirreadingisgood.order.controller.mapper.OrderMapper;
import com.example.getirreadingisgood.order.controller.model.response.OrderResponse;
import com.example.getirreadingisgood.order.controller.model.dto.OrderDto;
import com.example.getirreadingisgood.order.controller.model.request.OrderRequestBetweenDates;
import com.example.getirreadingisgood.order.entity.Order;
import com.example.getirreadingisgood.order.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/enter")
    public ResponseEntity<UUID> enterOrder(@RequestBody @Valid OrderDto orderDto) {
        UUID orderId = orderService.enterOrder(OrderMapper.mapOrderDtoToOrder(orderDto, modelMapper));
        return ResponseEntity.ok().body(orderId);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable UUID orderId) {
        return ResponseEntity.ok().body(OrderMapper.mapOrderToOrderResponse(orderService.getOrderById(orderId), modelMapper));
    }

    @GetMapping("/dateFilter")
    public ResponseEntity<List<OrderResponse>> getOrdersBetweenDates(@RequestBody @Valid OrderRequestBetweenDates request) {
        List<Order> ordersBetweenDates = orderService.getOrdersBetweenDates(request.getStartDate(), request.getEndDate());
        List<OrderResponse> orderResponses = ordersBetweenDates.stream()
                .map(order -> OrderMapper.mapOrderToOrderResponse(order, modelMapper))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(orderResponses);
    }
}
