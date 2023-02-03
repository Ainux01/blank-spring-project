package com.example.demo1.customer;


import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id){
        return this.customerService.getCustomer(id);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return this.customerService.getCustomers();
    }

    @PostMapping
    public void postCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("Customer POST : ");
        System.out.println(customer);
    }


    @PutMapping
    public void putCustomer(@RequestBody Customer customer) {
        System.out.println("Customer PUT : ");
        System.out.println(customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("DELETE Customer With Id : "+id);
    }

}
