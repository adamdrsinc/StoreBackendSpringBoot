package com.adamdrsinc.StoreSpringBoot.authorization;

import com.adamdrsinc.StoreSpringBoot.authorization.login.LoginDto;
import com.adamdrsinc.StoreSpringBoot.authorization.register.RegisterDto;
import com.adamdrsinc.StoreSpringBoot.customer.Customer;
import com.adamdrsinc.StoreSpringBoot.customer.CustomerRepository;
import com.adamdrsinc.StoreSpringBoot.role.Role;
import com.adamdrsinc.StoreSpringBoot.role.RoleRepository;
import com.nimbusds.jose.proc.SecurityContext;
import jakarta.persistence.*;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager,
                          CustomerRepository customerRepository,
                          RoleRepository roleRepository,
                          BCryptPasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername(),
                            loginDto.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("User signed in successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        if(customerRepository.findByUsername(registerDto.getUsername()).isPresent()){
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        Customer newCustomer = new Customer();
        newCustomer.setUsername(registerDto.getUsername());
        newCustomer.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        newCustomer.setFirstName(registerDto.getFirstName());
        newCustomer.setLastName(registerDto.getLastName());
        newCustomer.setCreated(LocalDateTime.now());
        newCustomer.setCustomerEmail(registerDto.getCustomerEmail());

        Role role = roleRepository.findByName("USER").get();

        newCustomer.setCustomerRole(Stream.of(role).toList());

        customerRepository.save(newCustomer);

        return new ResponseEntity<>("User registered success.", HttpStatus.OK);
    }

}
