package com.codecool.shop.service;

import com.codecool.shop.dao.CustomerDao;
import com.codecool.shop.model.Customer;

public class CustomerService {
    private CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void registration(Customer customer) {
        if (customerDao.findByEmail(customer.getEmail()) == null) {
            customerDao.add(customer);
        }else{
            throw new IllegalArgumentException("Email is not available!");
        }
    }

    public Customer getCostumerByEmail(String email) {
        return customerDao.findByEmail(email);
    }
}
