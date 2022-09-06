package com.techmaster.wlminus.repository;

import com.techmaster.wlminus.FakeDB;
import com.techmaster.wlminus.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CustomerRepository {
    public List<Customer> getAll() {
        return FakeDB.database;
    }

    public Optional<Customer> getById(Integer id) {
        return FakeDB.database.stream().filter(f -> Objects.equals(f.getId(), id)).findAny();
    }

    public Customer add(Customer customer) {
        FakeDB.database.add(customer);
        return customer;
    }

    public Customer updateById(Integer id, Customer newCustomer) {
        var oldCustomer = this.getById(id);
        if (oldCustomer.isPresent()) {
            var realCustomer = oldCustomer.get();
            realCustomer.setId(newCustomer.getId());
            realCustomer.setName(newCustomer.getName());
            realCustomer.setAddress(newCustomer.getAddress());
            realCustomer.setTel(newCustomer.getTel());

            return realCustomer;
        } else {
            throw new RuntimeException("Customer not found");
        }
    }

    public void deleteById(Integer id) {
        FakeDB.database.removeIf(customer -> Objects.equals(customer.getId(), id));
    }
}
