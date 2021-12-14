package com.codecool.shop.dao;

import com.codecool.shop.model.Cart;

public interface CartDao {

    void add(Cart cart);
    void addToCart(String productName, ProductDao product);
}
