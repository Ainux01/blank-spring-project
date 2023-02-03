package com.example.demo1.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2/customers")
public class CustomerControllerV2 {
    private final CustomerService customerService;

    public CustomerControllerV2(CustomerService customerService) {
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
    public void postCustomer(@RequestBody Customer customer) {
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
