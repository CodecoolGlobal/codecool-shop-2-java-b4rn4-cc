package com.codecool.shop.dao.implementation.memory;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;

import java.util.List;


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
    public void addToCart(Product product) {
        data.add(product);
    }

    @Override
    public List<Product> reviewCart() {
        return data.getCart();
    }

    @Override
    public void deleteFromCart(int index) {
        data.delete(index);
    }

    //    @Override
//    public void addToCart(String productName, Product product) {
//        data.add(productName, product);
//    }
//
//    @Override
//    public HashMap<String, Product> reviewCart() {
//        return data.getCart();
//    }
}
