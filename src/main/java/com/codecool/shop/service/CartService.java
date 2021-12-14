package com.codecool.shop.service;


import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Product;

import java.util.HashMap;
import java.util.List;

public class CartService {
        private CartDao cartDao;

        public CartService(CartDao cartDao){
                this.cartDao = cartDao;
        }

//        public HashMap<String, Product> getCartDao() {
//                return cartDao.reviewCart();
//        }

        public List<Product> getCartDao(){
                return cartDao.reviewCart();
        }


        public void addToCart(Product product){
                String productName = product.getName();
                cartDao.addToCart(product);
//                cartDao.addToCart(productName, product);
        }

}
