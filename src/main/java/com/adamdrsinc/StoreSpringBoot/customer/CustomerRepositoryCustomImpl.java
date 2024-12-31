package com.adamdrsinc.StoreSpringBoot.customer;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface CustomerRepositoryCustom {
    Optional<Customer> findByEmail(String email);
}

@Component
public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom{
    private final JdbcClient jdbcClient;

    public CustomerRepositoryCustomImpl(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return jdbcClient
                .sql("select * from customer where email=:email")
                .param("email", email)
                .query(Customer.class)
                .optional();
    }
}
