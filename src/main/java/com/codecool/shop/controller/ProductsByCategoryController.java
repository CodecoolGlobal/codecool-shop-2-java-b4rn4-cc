package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.service.ProductService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/tablet", "/console", "/smart watch", "/cell phone", "/computer", "/camera", "/television"})
public class ProductsByCategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        ProductService productService = new ProductService(productDataStore,productCategoryDataStore, supplierDataStore);
        String requestURI = request.getRequestURI();
        int categoryId = getCategoryId(requestURI);
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        context.setVariable("category", productService.getProductCategory(categoryId));
        context.setVariable("products", productService.getProductsForCategory(categoryId));
        context.setVariable("categories", productService.getProductCategories());
        context.setVariable("suppliers", productService.getProductSuppliers());

        engine.process("product/products.html", context, response.getWriter());
    }

    private int getCategoryId(String requestURI) {
        switch (requestURI) {
            case "/tablet":
                return 1;
            case "/console":
                return 2;
            case "/cell%20phone":
                return 3;
            case "/smart%20watch":
                return 4;
            case "/computer":
                return 5;
            case "/camera":
                return 6;
            case "/television":
                return 7;
        }
        return 0;
    }
}
