package com.example.getirreadingisgood.customer.service;

import com.example.getirreadingisgood.customer.entity.Customer;
import com.example.getirreadingisgood.customer.exception.CustomerDoesNotExistException;
import com.example.getirreadingisgood.customer.repository.CustomerRepository;
import com.example.getirreadingisgood.order.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private OrderService orderService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        customerService = new CustomerServiceImpl(customerRepository, orderService, bCryptPasswordEncoder);
    }

    @Test
    void testCustomerSearchWithUsernameThrows() {
        Customer customer = Customer.builder()
                .username("cgdsyilmaz")
                .build();

        when(customerRepository.findCustomerByUsername(customer.getUsername()))
                .thenReturn(Optional.empty());

        assertThrows(CustomerDoesNotExistException.class, () -> {
            customerService.getCustomerByUsername(customer.getUsername());
        });

    }

    @Test
    void testCustomerSearchWithUsernameSuccess() {
        Customer customer = Customer.builder()
                .username("cgdsyilmaz")
                .build();

        when(customerRepository.findCustomerByUsername(customer.getUsername()))
                .thenReturn(Optional.of(Customer.builder().username("cgdsyilmaz").build()));

        assertEquals(customer, customerService.getCustomerByUsername(customer.getUsername()));
    }

    @Test
    void testPasswordEncodingWithBCrypt() {
        Customer customer = Customer.builder()
                .password("12345")
                .build();

        String encodedPassword = bCryptPasswordEncoder.encode(customer.getPassword());

        assertNotEquals(encodedPassword, customer.getPassword());
    }

}