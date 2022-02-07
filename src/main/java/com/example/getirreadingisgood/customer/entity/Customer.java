package com.example.getirreadingisgood.customer.entity;

import com.example.getirreadingisgood.util.EntityConstraints;
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

    @NotBlank(message = EntityConstraints.FIRST_NAME_BLANK_MESSAGE)
    private String firstName;

    @NotBlank(message = EntityConstraints.LAST_NAME_BLANK_MESSAGE)
    private String lastName;

    @Indexed(unique = true)
    @NotEmpty(message = EntityConstraints.USERNAME_BLANK_MESSAGE)
    private String username;

    @NotEmpty(message = EntityConstraints.PASSWORD_NAME_BLANK_MESSAGE)
    private String password;

    @Indexed(unique = true)
    @Email(message = EntityConstraints.EMAIL_NOT_VALID_MESSAGE)
    private String email;

    private LocalDateTime registrationDate;
    private String address;

}
