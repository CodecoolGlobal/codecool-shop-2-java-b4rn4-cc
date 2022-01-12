package com.codecool.shop.dao;

import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;

import java.util.HashMap;
import java.util.List;

public interface CartDao {

    void add(Cart cart);
    Cart cartWithSingInUser(int userId);
    Cart createCart(int userId);
    void payOrder(Cart cart);

}
