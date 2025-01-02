package com.adamdrsinc.StoreSpringBoot.customer;

import com.adamdrsinc.StoreSpringBoot.customer.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findByUsername(username);
        if(customer.isEmpty())
            throw new CustomerNotFoundException("Customer not found when attempting " +
                    "loadUserByUsername in CustomerDetailsService.");

        return customer.get();
    }
}
