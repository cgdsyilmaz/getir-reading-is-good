package com.example.getirreadingisgood.customer.repository;


import com.example.getirreadingisgood.customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CustomerRepository extends MongoRepository<Customer, UUID> {

}
