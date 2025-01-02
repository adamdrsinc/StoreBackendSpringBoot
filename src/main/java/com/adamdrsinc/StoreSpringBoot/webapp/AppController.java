package com.adamdrsinc.StoreSpringBoot.webapp;

import com.adamdrsinc.StoreSpringBoot.customer.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    private CustomerRepository customerRepository;

    public AppController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
}
