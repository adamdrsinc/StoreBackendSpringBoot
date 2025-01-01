package com.adamdrsinc.StoreSpringBoot.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/")
    public String home(){
        return "home page";
    }

    @GetMapping("/secure")
    public String secured(){
        return "secured";
    }
}
