package com.codecool.shop.dao.implementation.memory;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;

import java.util.List;


public class CartDaoMem implements CartDao {
    static Cart data;
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
    public void addToCart(Product product) {

    }

    @Override
    public List<Product> reviewCart() {
        return null;
    }

    @Override
    public void deleteFromCart(int index) {

    }

    @Override
    public Cart cartWithSingInUser(int userId) {
        return data;
    }

    @Override
    public Cart createCart(int userId) {
        return null;
    }
}
