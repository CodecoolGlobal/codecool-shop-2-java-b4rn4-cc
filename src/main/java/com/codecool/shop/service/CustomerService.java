package com.codecool.shop.service;

import com.codecool.shop.dao.implementation.CustomerDaoJdbc;
import com.codecool.shop.model.Customer;

public class CustomerService {
    private CustomerDaoJdbc customerDaoJdbc;

    public CustomerService(CustomerDaoJdbc customerDaoJdbc) {
        this.customerDaoJdbc = customerDaoJdbc;
    }

    public void registration(Customer customer) {
        if (customerDaoJdbc.findByEmail(customer.getEmail()) == null) {
            customerDaoJdbc.add(customer);
        }else{
            throw new IllegalArgumentException("Email is not available!");
        }
    }

    public Customer getCostumerByEmail(String email) {
        return customerDaoJdbc.findByEmail(email);
    }
}
