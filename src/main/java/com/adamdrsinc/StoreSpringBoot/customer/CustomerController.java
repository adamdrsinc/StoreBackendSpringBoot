package com.adamdrsinc.StoreSpringBoot.customer;

import com.adamdrsinc.StoreSpringBoot.customer.exceptions.CustomerAlreadyExistsException;
import com.adamdrsinc.StoreSpringBoot.customer.exceptions.CustomerNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerRepository customerRepo;


    public CustomerController(CustomerRepository customerRepo){
        this.customerRepo = customerRepo;
    }

    @GetMapping("/all")
    List<Customer> findAll(){
        return customerRepo.findAll();
    }

    @GetMapping("/id/{id}")
    Customer findById(@PathVariable Integer id){
        var oCustomer = customerRepo.findById(id);
        if(oCustomer.isEmpty()){
            throw new CustomerNotFoundException("Customer with ID {" + id + "} not found.");
        }
        return oCustomer.get();
    }

    @GetMapping("/email/{email}")
    Customer findCustomerByEmail(@PathVariable String email){
        var oCustomer = customerRepo.findCustomerByCustomerEmail(email);
        if(oCustomer.isEmpty())
            throw new CustomerNotFoundException("Customer with email {" + email + "} not found.");
        return oCustomer.get();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@Valid @RequestBody Customer newCustomer){
        var oCustomer = customerRepo.findCustomerByCustomerEmail(newCustomer.getCustomerEmail());
        if(oCustomer.isPresent()){
            throw new CustomerAlreadyExistsException(
                    "Customer with email {" + newCustomer.getCustomerEmail() + "} already exists.");
        }
        customerRepo.save(newCustomer);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@Valid @RequestBody Customer newCustomer, @PathVariable Integer id){
        var oCustomer = customerRepo.findById(id);
        if(oCustomer.isEmpty()){
            throw new CustomerNotFoundException("Customer with ID {" + id + "} not found. Update failed.");
        }
        customerRepo.save(newCustomer);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id){
        var oCustomer = customerRepo.findById(id);
        if(oCustomer.isEmpty()){
            throw new CustomerNotFoundException("Customer with ID {" + id + "} not found. Delete failed.");
        }
        customerRepo.delete(oCustomer.get());
    }

}
