package com.codecool.shop.dao.implementation.memory;

import com.codecool.shop.dao.ProductInCartDao;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;

import java.util.List;

public class ProductInCartDaoMem implements ProductInCartDao {

    private static ProductInCartDaoMem instance = null;

    private ProductInCartDaoMem() {
    }

    public static ProductInCartDaoMem getInstance() {
        if (instance == null) {
            instance = new ProductInCartDaoMem();
        }
        return instance;
    }

    @Override
    public void add(int cartId, Product product) {
        CartDaoMem.data.add(product);
    }

    @Override
    public void deleteInCartByProductID(int cartId, int productId) {

    }

    @Override
    public void deleteByCartID(int cartID) {

    }

    @Override
    public List<Product> reviewCart(int cartID) {
        return CartDaoMem.data.getCart();
    }
}
