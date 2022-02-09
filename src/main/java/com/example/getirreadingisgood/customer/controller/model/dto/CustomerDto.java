package com.example.getirreadingisgood.customer.controller.model.dto;

import com.example.getirreadingisgood.util.EntityConstraints;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class CustomerDto {
    @NotBlank(message = EntityConstraints.FIRST_NAME_BLANK_MESSAGE)
    private String firstName;

    @NotBlank(message = EntityConstraints.LAST_NAME_BLANK_MESSAGE)
    private String lastName;

    @NotEmpty(message = EntityConstraints.USERNAME_BLANK_MESSAGE)
    private String username;

    @NotEmpty(message = EntityConstraints.PASSWORD_NAME_BLANK_MESSAGE)
    private String password;

    @Email(message = EntityConstraints.EMAIL_NOT_VALID_MESSAGE)
    private String email;
    private String address;
}
