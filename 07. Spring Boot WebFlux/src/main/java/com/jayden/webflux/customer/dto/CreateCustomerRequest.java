package com.jayden.webflux.customer.dto;

import com.jayden.webflux.customer.Customer;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateCustomerRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    public Customer toEntity() {
        return Customer.builder()
            .firstName(firstName)
            .lastName(lastName)
            .build();
    }
}
