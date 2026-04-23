package com.jieyang.customermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jieyang.customermanagement.dao.CustomerRepository;
import com.jieyang.customermanagement.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Customer findById(int theId) {
        Optional<Customer> result = customerRepository.findById(theId);

        Customer customer = null;

        if (result.isPresent()) {
            customer = result.get();
        } else {
            throw new RuntimeException("Did not find customer id - " + theId);
        }

        return customer;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }
}