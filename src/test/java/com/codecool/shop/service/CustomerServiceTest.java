package com.codecool.shop.service;

import com.codecool.shop.dao.CustomerDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Customer;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    CustomerDao mockCustomerDao = mock(CustomerDao.class);
    private Customer testCustomer;

    @BeforeEach
    void setTestCustomer(){
        testCustomer = new Customer("test", "email", "pw");
    }

    @Test
    void registration_emailNotRegistered_returnTrue(){
        when(mockCustomerDao.findByEmail("email")).thenReturn(null);
        CustomerService testService = new CustomerService(mockCustomerDao);
        assertTrue(testService.registration(testCustomer));
    }

    @Test
    void registration_emailRegistered_returnFalse(){
        when(mockCustomerDao.findByEmail("email")).thenReturn(testCustomer);
        CustomerService testService = new CustomerService(mockCustomerDao);
        assertFalse(testService.registration(testCustomer));
    }


    @Test
    void loginSuccess_customerExist_returnTrue(){
        when(mockCustomerDao.findByEmail("email")).thenReturn(testCustomer);
        CustomerService testService = new CustomerService(mockCustomerDao);
        assertTrue(testService.loginSuccess(testCustomer));
    }

    @Test
    void loginSuccess_customerDoesNotExist_returnFalse(){
        when(mockCustomerDao.findByEmail("email")).thenReturn(null);
        CustomerService testService = new CustomerService(mockCustomerDao);
        assertFalse(testService.loginSuccess(testCustomer));
    }

    @Test
    void loginSuccess_customerExistButPasswordIsWrong_returnFalse(){
        Customer registeredCustomer = new Customer("test", "email", "test");
        when(mockCustomerDao.findByEmail("email")).thenReturn(registeredCustomer);
        CustomerService testService = new CustomerService(mockCustomerDao);
        assertFalse(testService.loginSuccess(testCustomer));
    }


}
