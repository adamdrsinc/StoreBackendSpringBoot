package com.adamdrsinc.StoreSpringBoot.customer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class CustomerJSONDataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CustomerJSONDataLoader.class);
    private final CustomerRepository customerRepository;
    private final ObjectMapper objectMapper;

    public CustomerJSONDataLoader(CustomerRepository customerRepository, ObjectMapper objectMapper){
        this.customerRepository = customerRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if(customerRepository.count() == 0){
            try(InputStream is = TypeReference.class.getResourceAsStream("/data/customers.json")){
                Customers allCustomers = objectMapper.readValue(is, Customers.class);
                customerRepository.saveAll(allCustomers.customers());
            } catch(IOException e){
                throw new RuntimeException("Failed to load JSON data: " + e);
            }
        }else{
            logger.info("Customer count > 0. Not adding customers from JSON.");
        }
    }

}