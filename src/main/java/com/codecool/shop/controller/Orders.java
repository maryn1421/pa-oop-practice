package com.codecool.shop.controller;


import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.ShopDatabaseManager;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.dao.implementation.OrderMemoryDaoMem;
import com.codecool.shop.model.Order;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = {"/orders"})
public class Orders extends HttpServlet {
    ShopDatabaseManager dbManager;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) userName = cookie.getValue();
            }
        }
        if (userName == null) {
            resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/"));
        }
        try {
            setupDbManager();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        try {
            context.setVariable("username", userName);
            context.setVariable("orders",dbManager.getOrdersByUsername(userName));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        engine.process("product/orders.html", context, resp.getWriter());
    }

    private void setupDbManager() throws SQLException {
        dbManager = new ShopDatabaseManager();
        dbManager.setup();
    }
}
