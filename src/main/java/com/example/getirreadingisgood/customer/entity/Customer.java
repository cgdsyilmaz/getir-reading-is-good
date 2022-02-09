package com.example.getirreadingisgood.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class Customer {

    @Id
    private UUID customerId;
    private String firstName;
    private String lastName;

    @Indexed(unique = true)
    private String username;
    private String password;

    @Indexed(unique = true)
    private String email;

    private LocalDateTime registrationDate;
    private String address;

}
