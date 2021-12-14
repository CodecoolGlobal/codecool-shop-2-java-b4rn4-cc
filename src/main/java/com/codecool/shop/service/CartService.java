package com.codecool.shop.service;


import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Product;

public class CartService {
        private CartDao cartDao;

        public CartService(CartDao cartDao){
                this.cartDao = cartDao;
        }

        public CartDao getCartDao() {
                return cartDao;
        }

        public void addToCart(Product product){
                String productName = product.getName();
                cartDao.addToCart(productName, product);
        }
}
