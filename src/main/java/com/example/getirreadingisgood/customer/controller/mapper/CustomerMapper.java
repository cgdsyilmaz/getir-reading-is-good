package com.example.getirreadingisgood.customer.controller.mapper;

import com.example.getirreadingisgood.customer.controller.model.dto.CustomerDto;
import com.example.getirreadingisgood.customer.entity.Customer;
import org.modelmapper.ModelMapper;

public class CustomerMapper {

    public static Customer mapCustomerDtoToCustomer(CustomerDto customerDto, ModelMapper modelMapper) {
        return modelMapper.map(customerDto, Customer.class);
    }
}
