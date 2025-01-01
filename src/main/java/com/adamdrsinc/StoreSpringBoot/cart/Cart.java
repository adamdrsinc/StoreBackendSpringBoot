package com.adamdrsinc.StoreSpringBoot.cart;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record Cart(
        @Id
        Integer id,

        @NotNull
        Integer customerId,

        @NotNull
        Integer cartContentsId,

        @Version
        Long version
) {
}
