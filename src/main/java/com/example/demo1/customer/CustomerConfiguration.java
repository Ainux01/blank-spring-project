package com.example.demo1.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfiguration {

    @Value("${isFakeCustomerRepository:false}")
    private boolean isFakeCustomerRepo;//false

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Command Line Runner Arrouk");
        };
    }

    @Bean
    CustomerRepo customerRepo(){
        System.out.println("isFakeCustomerRepo : "+isFakeCustomerRepo);
        return isFakeCustomerRepo ? new CustomerFakeRepository() : new CustomerRepository();
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
