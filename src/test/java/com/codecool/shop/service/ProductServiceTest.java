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
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    private Product testProduct;
    private ProductCategory testCategory;
    ProductDao mockProductDao = mock(ProductDao.class);
    ProductCategoryDao mockCategoryDao = mock(ProductCategoryDao.class);
    SupplierDao mockSupplierDao = mock(SupplierDao.class);
    private Supplier testSupplier;

    @BeforeEach
    void setTestProduct() {
        testCategory = new ProductCategory("Tablet", "hardware", "");
        testSupplier = new Supplier("Samsong", "");
        testProduct = new Product("TestName", BigDecimal.TEN, "HUF", "Great device", testCategory, testSupplier);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 6, 11, 78})
    public void getProductById_existingProduct_returnsTheProduct(int id) {

        testProduct.setId(id);

        when(mockProductDao.find(testProduct.getId())).thenReturn(testProduct);
        ProductService testService = new ProductService(mockProductDao, mockCategoryDao, mockSupplierDao);

        assertEquals(testProduct, testService.getProductDaoById(id));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 6, 11, 78})
    public void getProductCategory_existingId_returnsCategory(int id) {
        testCategory.setId(id);

        when(mockCategoryDao.find(testCategory.getId())).thenReturn(testCategory);
        ProductService testService = new ProductService(mockProductDao, mockCategoryDao, mockSupplierDao);

        assertEquals(testCategory, testService.getProductCategory(id));
    }

    @Test
    public void getProductsForCategory_existingCategoryId_ListOfProducts() {
        ProductCategory category = new ProductCategory("Watch", "hardware", "");

        Product prod1 = new Product("Prod1", BigDecimal.valueOf(100D), "HUF", "", category, testSupplier);
        Product prod2 = new Product("Prod2", BigDecimal.valueOf(100D), "HUF", "", category, testSupplier);
        int testId = 2;

        List<Product> expected = new ArrayList<>();
        expected.add(prod1);
        expected.add(prod2);

        ProductService testService = new ProductService(mockProductDao, mockCategoryDao, mockSupplierDao);
        when(mockCategoryDao.find(testId)).thenReturn(category);
        when(mockProductDao.getBy(category)).thenReturn(expected);

        assertEquals(expected, testService.getProductsForCategory(testId));

    }


    @Test
    public void getProductById_nonExistingId_returnsNull() {
        int nonExistingId = -1;

        ProductService testService = new ProductService(mockProductDao, mockCategoryDao, mockSupplierDao);

        assertNull(testService.getProductDaoById(nonExistingId));
    }
}
