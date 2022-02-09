package com.example.getirreadingisgood.customer.controller;

import com.example.getirreadingisgood.customer.controller.mapper.CustomerMapper;
import com.example.getirreadingisgood.customer.controller.model.dto.CustomerDto;
import com.example.getirreadingisgood.customer.service.CustomerService;
import com.example.getirreadingisgood.order.controller.mapper.OrderMapper;
import com.example.getirreadingisgood.order.controller.model.response.OrderResponse;
import com.example.getirreadingisgood.order.entity.Order;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    public CustomerController(CustomerService customerService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UUID> registerCustomer(@RequestBody @Valid CustomerDto customerDto) {
        UUID customerId = customerService.registerCustomer(
                CustomerMapper.mapCustomerDtoToCustomer(customerDto, modelMapper));
        return ResponseEntity.ok().body(customerId);
    }

    @GetMapping("/{customerId}/orders")
    public ResponseEntity<List<OrderResponse>> getOrdersOfCustomer(@PathVariable UUID customerId,
                                                                   @RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "3") int size) {
        List<Order> customerOrders = customerService.getOrdersOfCustomer(customerId, page, size);
        List<OrderResponse> customerOrderResponses = customerOrders.stream()
                .map(order -> OrderMapper.mapOrderToOrderResponse(order, modelMapper))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(customerOrderResponses);
    }
}
