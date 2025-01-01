package com.adamdrsinc.StoreSpringBoot.cart;

import org.springframework.data.repository.ListCrudRepository;

public interface CartRepository extends ListCrudRepository<Cart, Integer> {
}
