package com.adamdrsinc.StoreSpringBoot.customer;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends ListCrudRepository<Customer, Integer>
{

}

