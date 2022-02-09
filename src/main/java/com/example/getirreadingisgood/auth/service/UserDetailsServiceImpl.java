package com.example.getirreadingisgood.auth.service;

import com.example.getirreadingisgood.auth.model.UserDetailsImpl;
import com.example.getirreadingisgood.customer.entity.Customer;
import com.example.getirreadingisgood.customer.service.CustomerService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final CustomerService customerService;

    public UserDetailsServiceImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerService.getCustomerByUsername(username);
        return new UserDetailsImpl(customer.getUsername(), customer.getEmail(), customer.getPassword());
    }
}
