package com.example.getirreadingisgood.customer.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@Document(collection = "customers")
public class Customer {

    @Id
    private UUID customerId;

    @NotBlank(message = "First name cannot be empty.")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty.")
    private String lastName;
    @NotEmpty(message = "Password cannot be empty.")
    private String password;

    @Indexed(unique = true)
    @Email(message = "Please enter a valid email address.")
    private String email;
    private LocalDateTime registrationDate;
    private String address;

}
