package com.codecool.shop.service;


import com.codecool.shop.dao.CartDao;

public class CartService {
        private CartDao cartDao;

        public CartService(CartDao cartDao){
                this.cartDao = cartDao;
        }

        public CartDao getCartDao() {
                return cartDao;
        }

}
