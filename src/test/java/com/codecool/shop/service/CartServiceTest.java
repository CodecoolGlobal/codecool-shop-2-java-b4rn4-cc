package com.codecool.shop.service;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductInCartDao;
import com.codecool.shop.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartServiceTest {

    CartDao mockCartDao = mock(CartDao.class);
    ProductInCartDao mockProductInCartDao = mock(ProductInCartDao.class);

    private Product getMockedProductWithPrice(String price){
        Product mockedProduct = mock(Product.class);
        when(mockedProduct.getPrice()).thenReturn(price);
        return mockedProduct;
    }

    private Customer setupCustomerCartWithTwoProduct(int cartId, int userId){
        Customer testCustomer = mock(Customer.class);

        List<Product> cartContents = new ArrayList<>();
        cartContents.add(getMockedProductWithPrice("1000 HUF"));
        cartContents.add(getMockedProductWithPrice("2000 HUF"));

        Cart mockCart = mock(Cart.class);
        when(mockCart.getId()).thenReturn(cartId);
        when(mockCartDao.cartWithSingInUser(userId)).thenReturn(mockCart);
        when(mockProductInCartDao.reviewCart(cartId)).thenReturn(cartContents);
        when(testCustomer.getId()).thenReturn(userId);
        return testCustomer;
    }


    @Test
    public void sumPrice_nonEmptyCart_returnActualPrice() {
        CartService testService = new CartService(mockCartDao, mockProductInCartDao);
        int cartId = 1;
        int userId = 1;
        Customer testCustomer = setupCustomerCartWithTwoProduct(cartId, userId);
        String expected = "3000 HUF";
 //       when(testService.getProductInCart(testCustomer)).thenReturn(cartContents);

        assertEquals(expected, testService.sumPrice(testCustomer));
    }
}
