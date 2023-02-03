package com.example.demo1.customer;

import java.util.Arrays;
import java.util.List;

//@Repository
//@Primary
public class CustomerRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1l,"Badr Ghanbi", "email@gmail.com", "12345678"),
                new Customer(2L,"Amine Arrouk", "email@gmail.com", "12345678"),
                new Customer(3l,"Swamer", "email@gmail.com", "12345678"),
                new Customer(4L,"Abdelmoumen", "email@gmail.com", "12345678")
        );
    }
}
