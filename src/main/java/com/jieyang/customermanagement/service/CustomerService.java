package com.jieyang.customermanagement.service;

import java.util.List;
import com.jieyang.customermanagement.entity.Customer;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(int theId);

    Customer save(Customer customer);

    void deleteById(int theId);
}
