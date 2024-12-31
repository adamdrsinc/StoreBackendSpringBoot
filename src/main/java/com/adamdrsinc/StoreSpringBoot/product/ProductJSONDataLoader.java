package com.adamdrsinc.StoreSpringBoot.product;

import com.adamdrsinc.StoreSpringBoot.customer.CustomerJSONDataLoader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ProductJSONDataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CustomerJSONDataLoader.class);
    private final ObjectMapper objectMapper;
    private final ProductRepository productRepository;

    public ProductJSONDataLoader(ProductRepository customerRepository, ObjectMapper objectMapper, ProductRepository productRepository){
        this.objectMapper = objectMapper;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count() == 0){
            try(InputStream is = TypeReference.class.getResourceAsStream("/data/products.json")){
                Products allProducts = objectMapper.readValue(is, Products.class);
                productRepository.saveAll(allProducts.products());
            } catch(IOException e){
                throw new RuntimeException("Failed to load JSON data: " + e);
            }
        } else{
            logger.info("Product count > 0. Not adding products from JSON.");
        }
    }

}


