package com.deeprogra.store.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deeprogra.store.model.Customer;
import com.deeprogra.store.service.CustomerService;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getEngineers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("{id}")
    public Customer getEngineerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public void addNewCustomer(@RequestBody Customer customer) {
        customerService.insertCustomer(customer);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping("{id}")
    public void updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
    }

}
