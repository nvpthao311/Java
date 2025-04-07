package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping
    public List<Customer> getAllAccounts() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getAccountById(@PathVariable Long id) {
        return Optional.ofNullable(customerService.getCustomerById(id));
    }

    @PostMapping
    public Customer createAccount(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateAccount(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateById(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

}
