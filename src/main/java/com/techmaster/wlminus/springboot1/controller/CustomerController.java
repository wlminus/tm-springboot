package com.techmaster.wlminus.springboot1.controller;

import com.techmaster.wlminus.springboot1.model.Customer;
import com.techmaster.wlminus.springboot1.repository.CustomerRepository;
import com.techmaster.wlminus.springboot1.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
@CrossOrigin(value = "*")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        var result = this.customerService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Integer customerId) {
        return ResponseEntity.ok(this.customerService.getById(customerId));
    }

    @PostMapping("")
    public ResponseEntity<Void> createNewCustomer(@RequestBody Customer newCustomer) {
        var ret = this.customerService.create(newCustomer);
        if (ret) {
            return ResponseEntity.created(URI.create("/")).body(null);
        } else {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PatchMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomerById(
            @PathVariable("customerId") Integer customerId,
            @RequestBody Customer newCustomer) {
        var ret = this.customerService.updateById(customerId, newCustomer);
        if (ret) {
            return ResponseEntity.ok().body(null);
        } else {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("customerId") Integer customerId) {
        var ret = this.customerService.deleteById(customerId);
        if (ret) {
            return ResponseEntity.ok().body(null);
        } else {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
