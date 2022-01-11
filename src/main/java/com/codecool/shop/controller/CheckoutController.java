package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductInCartDao;
import com.codecool.shop.dao.implementation.DaoRepository;
import com.codecool.shop.dao.implementation.memory.CartDaoMem;
import com.codecool.shop.service.CartService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        DaoRepository daoRepository = DaoRepository.getInstance();
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        CartDao cartDataStore = daoRepository.getCartDao();
        ProductInCartDao productInCartDataStore = daoRepository.getProductInCartDao();
        CartService cartService = new CartService(cartDataStore, productInCartDataStore);
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("products", cartService.getProductInCart());
        context.setVariable("price", cartService.sumPrice());
        engine.process("product/checkout.html", context, resp.getWriter());
    }
}
