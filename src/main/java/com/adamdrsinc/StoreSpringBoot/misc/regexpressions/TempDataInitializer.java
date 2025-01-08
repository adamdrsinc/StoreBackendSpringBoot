package com.adamdrsinc.StoreSpringBoot.misc.regexpressions;

import com.adamdrsinc.StoreSpringBoot.customer.Customer;
import com.adamdrsinc.StoreSpringBoot.customer.CustomerRepository;
import com.adamdrsinc.StoreSpringBoot.product.Product;
import com.adamdrsinc.StoreSpringBoot.product.ProductRepository;
import com.adamdrsinc.StoreSpringBoot.role.Role;
import com.adamdrsinc.StoreSpringBoot.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class TempDataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Insert fake roles
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setName("USER");
        roleRepository.save(userRole);

        // Insert fake customers
        Customer customer1 = new Customer();
        customer1.setUsername("john");
        customer1.setCustomerEmail("john.doe@example.com");
        customer1.setPassword(passwordEncoder.encode("abc"));
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setCreated(LocalDateTime.now());
        customer1.setCustomerRole(Arrays.asList(adminRole, userRole));
        customer1.setEnabled(true);
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setUsername("jane");
        customer2.setCustomerEmail("jane.doe@example.com");
        customer2.setPassword(passwordEncoder.encode("abc"));
        customer2.setFirstName("Jane");
        customer2.setLastName("Doe");
        customer2.setCreated(LocalDateTime.now());
        customer2.setCustomerRole(Arrays.asList(userRole));
        customer2.setEnabled(true);
        customerRepository.save(customer2);

        // Insert fake products
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setPrice(10.99);
        product1.setDescription("Description for product 1");
        product1.setStockCount(100L);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setPrice(20.99);
        product2.setDescription("Description for product 2");
        product2.setStockCount(200L);
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setPrice(30.99);
        product3.setDescription("Description for product 3");
        product3.setStockCount(300L);
        productRepository.save(product3);
    }
}
