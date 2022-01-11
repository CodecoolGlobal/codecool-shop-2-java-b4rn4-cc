package com.codecool.shop.dao;

import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;

import java.util.HashMap;
import java.util.List;

public interface CartDao {

    void add(Cart cart);
    void addToCart(Product product);
    void deleteFromCart(int index);
    List<Product> reviewCart();
    void cartWithSingInUser(int userId);
    Cart createCart(int userId);

}
