package com.example.demo1.customer;

import com.example.demo1.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class CustomerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }
    public Customer getCustomer(Long id){
        LOGGER.info("getCustomer was called");
        return getCustomers().stream()
                .filter(c -> c.getId().equals(id))
                .peek(System.out::println)
                .findFirst()
                .orElseThrow(() -> {
                    NotFoundException exception = new NotFoundException("Customer with id : "+id+" Not Found");
                    LOGGER.error(exception.getMessage(),exception);
                    return  exception;
                });
    }
    public List<Customer> getCustomers(){
        LOGGER.info("getCustomers was Called");
        return this.customerRepo.getCustomers();
    }
}
