package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.implementation.memory.CartDaoMem;
import com.codecool.shop.emailSender.EmailSender;
import com.codecool.shop.model.Customer;
import com.codecool.shop.service.CartService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/payment")
public class PaymentController extends HttpServlet {

    Customer customer;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartDao cartDataStore = CartDaoMem.getInstance();
        CartService cartService = new CartService(cartDataStore);

        EmailSender sender = new EmailSender();
        String emailAddress = customer.getEmail();
        String emailContent = "<div>Dear " + customer.getName() + "</div>" +
                "<div>Your order will be arrive shortly" + "\n" + "</div>" +
                "<div>Total price: " + cartService.sumPrice() + "\n" + "</div>" +
                "<div>Address:</div>" +
                "<div>" + customer.getState() + "\n" + "</div>" +
                "<div>" + customer.getZipCode() + "\n" + "</div>" +
                "<div>" + customer.getCity() + "\n" + "</div>" +
                "<div>" + customer.getAddress() + "</div>";
        sender.sendEmail(emailAddress, emailContent);
        response.sendRedirect(request.getContextPath() + "/successful-order");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        CartDao cartDataStore = CartDaoMem.getInstance();
        CartService cartService = new CartService(cartDataStore);
        customer = new Customer(request.getParameter("name"), request.getParameter("email"),
                request.getParameter("address"), request.getParameter("city"), request.getParameter("state"),
                request.getParameter("zip"));

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        context.setVariable("cart", cartService.getCartDao());
        context.setVariable("totalPrice", cartService.sumPrice());
        engine.process("payment.html", context, response.getWriter());
    }
}
