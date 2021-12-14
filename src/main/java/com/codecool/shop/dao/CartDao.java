package com.codecool.shop.dao;

import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;

import java.util.HashMap;
import java.util.List;

public interface CartDao {

    void add(Cart cart);
    void addToCart(Product product);
    List<Product> reviewCart();
//    void addToCart(String productName, Product product);
//    HashMap<String, Product> reviewCart();
}
