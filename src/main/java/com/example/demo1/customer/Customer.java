package com.example.demo1.customer;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Customer {
    private final Long id;
    @NotBlank(message = "name must not be empty")
    private final String name;

    @NotBlank(message = "email must not be empty")
    @Email
    private final String email;
    @NotBlank(message = "password must not be empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private final String password;

    public String getEmail() {
        return email;
    }

    public Customer(Long id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @JsonProperty("customerId")
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    // customerId, it's due to Jackson parser
//    public Long getcustomerId() {
//        return getId();
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
