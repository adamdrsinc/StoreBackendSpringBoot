package com.adamdrsinc.StoreSpringBoot.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE c.customerEmail = :email")
    Optional<Customer> findCustomerByCustomerEmail(@Param("email") String email);

    @Query("SELECT c FROM Customer c WHERE c.username = :username")
    Optional<Customer> findByUsername(@Param("username") String username);
}