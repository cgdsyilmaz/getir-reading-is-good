package com.example.getirreadingisgood.customer.service;

import com.example.getirreadingisgood.customer.entity.Customer;
import com.example.getirreadingisgood.customer.exception.CustomerDoesNotExistException;
import com.example.getirreadingisgood.customer.exception.EmailExistsException;
import com.example.getirreadingisgood.customer.exception.UsernameExistsException;
import com.example.getirreadingisgood.customer.repository.CustomerRepository;
import com.example.getirreadingisgood.order.entity.Order;
import com.example.getirreadingisgood.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderService orderService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomerServiceImpl(CustomerRepository customerRepository, OrderService orderService,
                               BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.orderService = orderService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public UUID registerCustomer(Customer newCustomer) {
        setCustomerIdDateAndPassword(newCustomer);
        checkCustomerUsernameAndEmail(newCustomer);
        customerRepository.save(newCustomer);

        UUID customerId = newCustomer.getCustomerId();
        log.info("Customer created with id: " + customerId);

        return customerId;
    }

    private void setCustomerIdDateAndPassword(Customer newCustomer) {
        newCustomer.setCustomerId(UUID.randomUUID());
        newCustomer.setRegistrationDate(LocalDateTime.now());
        newCustomer.setPassword(bCryptPasswordEncoder.encode(newCustomer.getPassword()));
    }

    private void checkCustomerUsernameAndEmail(Customer newCustomer) {
        checkEmail(newCustomer);
        checkUsername(newCustomer);
    }

    private void checkEmail(Customer newCustomer) {
        Optional<Customer> customer = customerRepository.findCustomerByEmail(newCustomer.getEmail());
        if (customer.isPresent()) {
            throw new EmailExistsException();
        }
    }

    private void checkUsername(Customer newCustomer) {
        Optional<Customer> customer = customerRepository.findCustomerByUsername(newCustomer.getEmail());
        if (customer.isPresent()) {
            throw new UsernameExistsException();
        }
    }

    @Override
    public List<Order> getOrdersOfCustomer(UUID customerId, int page, int size) {
        return orderService.getOrdersOfCustomer(customerId, page, size);
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        Optional<Customer> customerByUsername = customerRepository.findCustomerByUsername(username);
        if (customerByUsername.isEmpty()) {
            throw new CustomerDoesNotExistException();
        }
        return customerByUsername.get();
    }
}