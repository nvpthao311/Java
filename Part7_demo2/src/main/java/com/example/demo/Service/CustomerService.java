package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    //them
    public Customer createCustomer (Customer customer) {
        return customerRepository.save(customer);
    }

    //sua
    public Customer updateById (long id, Customer customer){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()){
            Customer ctm = optionalCustomer.get();

            ctm.setName(customer.getName());
            ctm.setEmail(customer.getName());
            ctm.setPhone(customer.getPhone());

            customerRepository.save(ctm);
            return ctm;
        }
        return null;
    }

    //xoa
    public void deleteCustomer (long id){
        customerRepository.deleteById(id);
    }

    //tim kiem
    public Customer getCustomerById (long id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            return  customer;
        }
        return null;
    }

    public List<Customer> getAllCustomer (){
        return customerRepository.findAll();
    }




}
