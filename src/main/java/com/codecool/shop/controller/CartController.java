package com.codecool.shop.controller;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.DaoRepository;
import com.codecool.shop.dao.implementation.database.CartDaoJdbc;
import com.codecool.shop.dao.implementation.memory.CartDaoMem;
import com.codecool.shop.dao.implementation.memory.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.memory.ProductDaoMem;
import com.codecool.shop.dao.implementation.memory.SupplierDaoMem;
import com.codecool.shop.model.Customer;
import com.codecool.shop.service.CartService;
import com.codecool.shop.service.ProductService;
import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        DaoRepository daoRepository = DaoRepository.getInstance();

        ProductDao productDataStore = daoRepository.getProductDao();
        ProductCategoryDao productCategoryDataStore = daoRepository.getProductCategoryDao();
        SupplierDao supplierDataStore = daoRepository.getSupplierDao();
        CartDao cartDataStore = daoRepository.getCartDao();
        ProductService productService = new ProductService(productDataStore,productCategoryDataStore, supplierDataStore);
        CartService cartService = new CartService(cartDataStore);
        Customer customer = new Customer("","","","","","");
        String productID = request.getParameter("id");
        cartService.addToCart(customer, productService.getProductDaoById(Integer.parseInt(productID)));
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoRepository daoRepository = DaoRepository.getInstance();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        CartDao cartDataStore = daoRepository.getCartDao();
        CartService cartService = new CartService(cartDataStore);
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("products", cartService.getCartDao());
        context.setVariable("price", cartService.sumPrice());
        engine.process("product/cart-test.html", context, resp.getWriter());
    }


//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        CartDao cartDataStore = CartDaoMem.getInstance();
//        CartService cartService = new CartService(cartDataStore);
//        String productID = req.getParameter("id");
//        cartService.deleteFromCart(Integer.parseInt(productID));
//    }
}
