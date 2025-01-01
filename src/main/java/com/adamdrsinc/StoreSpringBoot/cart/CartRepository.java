package com.adamdrsinc.StoreSpringBoot.cart;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends ListCrudRepository<Cart, Integer> {
}
