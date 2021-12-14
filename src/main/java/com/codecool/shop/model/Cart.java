package com.codecool.shop.model;

import com.codecool.shop.dao.ProductDao;

import java.util.HashMap;

public class Cart {
    private HashMap<String, Product> cart = new HashMap<String, Product>();

    public void add(String productName, Product product){
        cart.put(productName, product);
    }
}
