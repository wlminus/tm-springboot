package com.techmaster.wlminus.springboot1.service;

import com.techmaster.wlminus.springboot1.model.Customer;
import com.techmaster.wlminus.springboot1.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        return this.customerRepository.getAll();
    }

    public Customer getById(Integer id) {
        var oCustomer = this.customerRepository.getById(id);
        if (oCustomer.isPresent()) {
            return oCustomer.get();
        } else {
            return null;
        }
    }

    public boolean create(Customer newCustomer) {
        var ret = this.customerRepository.add(newCustomer);
        if (ret != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateById(Integer id, Customer updater) {
        var ret = this.customerRepository.updateById(id, updater);
        if (ret != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteById(Integer id) {
        return this.customerRepository.deleteById(id);
    }
}
