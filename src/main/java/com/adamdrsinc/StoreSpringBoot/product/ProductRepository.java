package com.adamdrsinc.StoreSpringBoot.product;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Optional<Product> findProductByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.price = :price WHERE p.id = :id")
    void updatePrice(@Param("id") Integer id, @Param("price") Double price);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.name = :name, p.price = :price, p.description = :description, p.stockCount = :stockCount WHERE p.id = :id")
    void updateProductById(@Param("id") Integer id, @Param("name") String name, @Param("price") Double price, @Param("description") String description, @Param("stockCount") Long stockCount);
}