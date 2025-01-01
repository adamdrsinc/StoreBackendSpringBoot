package com.adamdrsinc.StoreSpringBoot.cart;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Version;

@Entity
public class Cart {
        @Id
        Integer id;

        @NotNull
        Integer customerId;

        @NotNull
        Integer cartContentsId;

        @Version
        Long version;
}
