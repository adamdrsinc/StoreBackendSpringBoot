package com.adamdrsinc.StoreSpringBoot.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends ListCrudRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c WHERE c.customerEmail = :email")
    Optional<Customer> findCustomerByCustomerEmail(@Param("email") String email);
}