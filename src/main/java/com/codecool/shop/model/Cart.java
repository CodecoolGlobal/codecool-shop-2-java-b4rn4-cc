package com.codecool.shop.model;

import com.codecool.shop.dao.ProductDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
//    private HashMap<String, Product> cart = new HashMap<String, Product>();

    private List<Product> cart = new ArrayList<>();

    public void add(Product product){
        cart.add(product);
    }

    public List<Product> getCart() {
        return cart;
    }

    public void delete(int index){
        cart.remove(index);
    }

//    public void add(String productName, Product product){
//        cart.put(productName, product);
//    }
//
//    public HashMap<String, Product> getCart() {
//        return cart;
//    }
}
