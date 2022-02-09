package com.example.getirreadingisgood.customer.controller.mapper;

import com.example.getirreadingisgood.customer.controller.model.dto.CustomerDto;
import com.example.getirreadingisgood.customer.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerMapperTest {
    private ModelMapper modelMapper;

    @BeforeEach
    void setup() {
        modelMapper = new ModelMapper();
    }

    @Test
    void checkFieldEqualityAfterConversion() {
        CustomerDto customerDto = CustomerDto.builder()
                .firstName("Cagdas")
                .lastName("Yilmaz")
                .username("cgdsyilmaz")
                .email("cagdasyilmaz96@gmail.com")
                .address("ankara")
                .password("12345")
                .build();

        Customer customer = CustomerMapper.mapCustomerDtoToCustomer(customerDto, modelMapper);

        assertEquals(customerDto.getFirstName(), customer.getFirstName());
        assertEquals(customerDto.getLastName(), customer.getLastName());
        assertEquals(customerDto.getUsername(), customer.getUsername());
        assertEquals(customerDto.getEmail(), customer.getEmail());
        assertEquals(customerDto.getAddress(), customer.getAddress());
    }

}