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

        public void deleteFromCart(int index){
                cartDao.deleteFromCart(index);
        }

        public String sumPrice(){
                int sum = 0;
                String slicedPrice = "";
                for(Product product : cartDao.reviewCart()){
                        String strPrice = product.getPrice();
                        slicedPrice = strPrice.substring(0, strPrice.length()-4);
                        sum += Integer.parseInt(slicedPrice);
                }
                return String.valueOf(sum) + " HUF";
        }

}
