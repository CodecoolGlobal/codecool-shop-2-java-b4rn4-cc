package com.codecool.shop.service;

import com.codecool.shop.dao.CustomerDao;
import com.codecool.shop.model.Customer;

public class CustomerService {
    private CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public boolean registration(Customer customer) {
//        if (customerDao.findByEmail(customer.getEmail()) == null) {
            customerDao.add(customer);
            return true;
//        }else{
//            return false;
//        }
    }

    public Customer getCostumerByEmail(String email) {
        return customerDao.findByEmail(email);
    }
}
