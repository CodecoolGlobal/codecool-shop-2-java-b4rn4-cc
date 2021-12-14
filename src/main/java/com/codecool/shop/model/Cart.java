package com.codecool.shop.model;

import com.codecool.shop.dao.ProductDao;

import java.util.HashMap;

public class Cart {
    private HashMap<String, ProductDao> cart = new HashMap<String, ProductDao>();

    public void add(String productName, ProductDao product){
        cart.put(productName, product);
    }
}
