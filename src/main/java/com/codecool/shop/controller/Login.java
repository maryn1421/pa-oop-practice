package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ShopDatabaseManager;
import com.codecool.shop.model.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {
    ShopDatabaseManager dbManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        engine.process("product/login.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            setUpDbManager();
            List<User> userList = dbManager.getAllUsers();
            for (User user : userList) {
                if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("Login was successful");
                    Cookie loginCookie = new Cookie("user", username);
                    loginCookie.setMaxAge(30 * 60);
                    resp.addCookie(loginCookie);
                    resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/"));
                }else {
                    resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/login"));
                }
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private void setUpDbManager() throws SQLException {
        dbManager = new ShopDatabaseManager();
        dbManager.setup();
    }
}
