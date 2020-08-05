package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ShopDatabaseManager;
import com.codecool.shop.model.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/registration"})
public class Registration extends HttpServlet {
    ShopDatabaseManager dbManager;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        engine.process("product/registration.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("fname");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String zipCode = req.getParameter("zipcode");
        String password = req.getParameter("password");
        String username = req.getParameter("username");

        System.out.println(email + "" + name + address + city   + zipCode + password + username);
        try {
            setupDbManager();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        User user = new User(name, email, username, zipCode, city, address, password);
        dbManager.registerUser(user);
        resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/login"));
        resp.sendRedirect("/login");
    }

    private void setupDbManager() throws SQLException {
        dbManager = new ShopDatabaseManager();
        dbManager.setup();
    }
}

