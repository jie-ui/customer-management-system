package com.jieyang.customermanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jieyang.customermanagement.entity.Customer;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // sort by last name
    List<Customer> findAllByOrderByLastNameAsc();

}