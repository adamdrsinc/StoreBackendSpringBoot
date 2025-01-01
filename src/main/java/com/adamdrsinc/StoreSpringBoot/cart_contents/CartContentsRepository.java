package com.adamdrsinc.StoreSpringBoot.cart_contents;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartContentsRepository extends ListCrudRepository<CartContents, CartContentsId> {
}
