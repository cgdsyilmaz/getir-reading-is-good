package com.example.getirreadingisgood.customer.service;

import com.example.getirreadingisgood.customer.entity.Customer;
import com.example.getirreadingisgood.order.entity.Order;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    UUID registerCustomer(Customer newCustomer);
    List<Order> getOrdersOfCustomer(UUID customerId, int page, int size);
    Customer getCustomerByUsername(String username);
}
