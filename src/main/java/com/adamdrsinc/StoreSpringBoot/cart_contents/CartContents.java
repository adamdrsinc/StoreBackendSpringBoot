package com.adamdrsinc.StoreSpringBoot.cart_contents;

import org.springframework.data.annotation.Id;

public record CartContents(
        @Id
        Integer id,
) {
}
