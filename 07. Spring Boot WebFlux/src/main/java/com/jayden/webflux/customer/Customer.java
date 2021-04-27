package com.jayden.webflux.customer;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@Builder
public class Customer {

    @Id
    private Long id;

    private final String firstName;

    private final String lastName;

    @Override
    public String toString() {
        return String.format(
            "Customer[id=%d, firstName='%s', lastName='%s']",
            id, firstName, lastName);
    }
}
