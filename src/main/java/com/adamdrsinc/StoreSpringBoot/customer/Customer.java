package com.adamdrsinc.StoreSpringBoot.customer;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record Customer(
        @Id
        Integer id,

        @NotEmpty
        String firstName,

        @NotEmpty
        String lastName,

        @NotEmpty
        String customerEmail,

        @Version
        Integer version
) {
}
