package com.jieyang.customermanagement.controller;

import java.util.List;

import com.jieyang.customermanagement.entity.Customer;
import com.jieyang.customermanagement.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {

        // get customers from database
        List<Customer> customers = customerService.findAll();

        // add to Spring model
        model.addAttribute("customers", customers);

        return "customers/list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        // create model attribute to bind form data
        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customers/customer-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model model) {

        // get the customer from the service
        Customer customer = customerService.findById(theId);

        // set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);

        // send over to form
        return "customers/customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        // save the customer
        customerService.save(customer);

        // use a redirect to prevent duplicate submissions
        return "redirect:/customers/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId) {

        // delete the customer
        customerService.deleteById(theId);

        // redirect to /customers/list
        return "redirect:/customers/list";
    }
}