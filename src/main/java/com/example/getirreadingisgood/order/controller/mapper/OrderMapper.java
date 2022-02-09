package com.example.getirreadingisgood.order.controller.mapper;

import com.example.getirreadingisgood.order.controller.model.response.OrderResponse;
import com.example.getirreadingisgood.order.controller.model.dto.OrderDto;
import com.example.getirreadingisgood.order.entity.Order;
import org.modelmapper.ModelMapper;

public class OrderMapper {
    public static OrderResponse mapOrderToOrderResponse(Order order, ModelMapper modelMapper) {
        return modelMapper.map(order, OrderResponse.class);
    }

    public static Order mapOrderDtoToOrder(OrderDto orderDto, ModelMapper modelMapper) {
        return modelMapper.map(orderDto, Order.class);
    }
}
