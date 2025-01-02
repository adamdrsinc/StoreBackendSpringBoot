package com.adamdrsinc.StoreSpringBoot.webapp;

import com.adamdrsinc.StoreSpringBoot.customer.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AppController {
    private CustomerRepository customerRepository;

    public AppController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    /*@RequestMapping("")
    public String viewHomePage() {
        return "index";
    }

    @RequestMapping("/login")
    public String viewLoginPage() {return "login";}

    @RequestMapping("/logout-success")
    public String viewLogoutPage() {return "logout";}*/
}
