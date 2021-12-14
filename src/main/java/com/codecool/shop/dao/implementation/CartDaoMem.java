package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Cart;


public class CartDaoMem implements CartDao {
    private Cart data;
    private static CartDaoMem instance = null;


    private CartDaoMem() {
    }

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Cart cart) {
        this.data = cart;
    }

    @Override
    public void addToCart(String productName, ProductDao product) {
        data.add(productName, product);
    }
}
