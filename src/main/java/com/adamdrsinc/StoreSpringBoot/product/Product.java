package com.adamdrsinc.StoreSpringBoot.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record Product(
        @Id
        Integer id,

        @NotEmpty
        String name,

        @NotNull
        Double price,

        String description,

        @NotNull
        Long stockCount,

        @Version
        Integer version
) {
}
