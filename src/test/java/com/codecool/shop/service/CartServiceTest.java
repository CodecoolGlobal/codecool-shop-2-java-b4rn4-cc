package com.codecool.shop.service;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductInCartDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
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

    @Test
    public void sumPrice_nonEmptyCart_returnActualPrice() {
        CartService testService = new CartService(mockCartDao, mockProductInCartDao);
        List<Product> cartContents = new ArrayList<>();
        Product product1 = new Product("Watch", BigDecimal.valueOf(1000L), "HUF", "", new ProductCategory("Smart Watch", "Hardware", ""), new Supplier("Samsong", ""));
        Product product2 = new Product("Watch", BigDecimal.valueOf(2000L), "HUF", "", new ProductCategory("Smart Watch", "Hardware", ""), new Supplier("Samsong", ""));
        cartContents.add(product1);
        cartContents.add(product2);

        // TODO: 2022. 01. 13. ask mentor why this not working
//        when(mockProductInCartDao.reviewCart(1)).thenReturn(cartContents);
        when(testService.getProductInCart()).thenReturn(cartContents);

        assertEquals("3000 HUF", testService.sumPrice());
    }
}
