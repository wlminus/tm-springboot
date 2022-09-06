package com.techmaster.wlminus.controller;

import com.techmaster.wlminus.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {
    private CustomerRepository customerRepository;


}
