package com.example.demo1.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

//@Repository(value = "fake")
public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Collections.singletonList(new Customer(1L,"TODO : Real DB","email@gmail.com","todo"));
    }
}
