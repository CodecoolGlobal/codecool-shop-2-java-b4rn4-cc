package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class ProductInCart {

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
}
