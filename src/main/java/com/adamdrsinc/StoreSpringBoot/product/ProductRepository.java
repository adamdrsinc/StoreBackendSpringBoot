package com.adamdrsinc.StoreSpringBoot.product;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Integer> {
    @Query("SELECT id, name, price, description, stock_count, version FROM Product WHERE name = :name")
    Optional<Product> findProductByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Product SET price = :price WHERE id = :id")
    void updatePrice(@Param("id") Integer id, @Param("price") Double price);

    @Modifying
    @Transactional
    @Query("UPDATE Product SET name = :name, price = :price, " +
            "description = :description, stock_count = :stockCount WHERE id = :id")
    void updateProductById(@Param("id") Integer id, @Param("name") String name, @Param("price") Double price,
                           @Param("description") String description, @Param("stockCount") Long stockCount);
}