package com.techmaster.wlminus.springboot1.controller;

import com.techmaster.wlminus.springboot1.model.Customer;
import com.techmaster.wlminus.springboot1.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {
    private CustomerRepository customerRepository;


}
