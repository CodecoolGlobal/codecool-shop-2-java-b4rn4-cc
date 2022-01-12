package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    private Product testProduct;
    ProductDao mockProductDao = mock(ProductDao.class);
    ProductCategoryDao mockCategoryDao = mock(ProductCategoryDao.class);
    SupplierDao mockSupplierDao = mock(SupplierDao.class);

    @BeforeEach
    void setTestProduct() {
        testProduct = new Product("TestName", BigDecimal.TEN, "HUF", "Great device", new ProductCategory("Tablet", "hardware", ""), new Supplier("Samsong", ""));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 6, 11, 78})
    public void getProductById_existingProduct_returnsTheProduct(int id) {

        testProduct.setId(id);

        when(mockProductDao.find(testProduct.getId())).thenReturn(testProduct);
        ProductService testService = new ProductService(mockProductDao, mockCategoryDao, mockSupplierDao);

        assertEquals(testProduct, testService.getProductDaoById(id));
    }
}
