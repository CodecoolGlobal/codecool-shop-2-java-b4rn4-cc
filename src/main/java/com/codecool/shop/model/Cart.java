package com.codecool.shop.model;

import com.codecool.shop.dao.ProductDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
    int id;
    private int userId;
    private boolean payed = false;

    private List<Product> cart = new ArrayList<>();

    public Cart() {
    }

    public Cart(int id, int userId, boolean payed) {
        this.id = id;
        this.userId = userId;
        this.payed = payed;
    }

    public void add(Product product){
        cart.add(product);
    }

    public List<Product> getCart() {
        return cart;
    }

    public void delete(int index){
        cart.remove(index);
    }

    public int getUserId() {
        return userId;
    }

    public boolean isPayed() {
        return payed;
    }

    public void pay(){
        if (!payed){
            payed = true;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
