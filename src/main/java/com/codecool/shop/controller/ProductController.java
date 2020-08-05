package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.*;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
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


@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {
    ShopDatabaseManager dbManager;
    int categoryId = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) userName = cookie.getValue();
            }
        }
        if(req.getParameter("category-option") != null){
            String optionValue =req.getParameter("category-option");
            categoryId =Integer.parseInt(optionValue);
        }
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        CartDao cartDaoDataStore = CartDaoMem.getInstance();

        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("products", productDataStore.getAll());
        context.setVariable("categories",productCategoryDataStore.getAll());
        context.setVariable("cart", cartDaoDataStore);
        context.setVariable("cartitems", cartDaoDataStore.getCart());
        context.setVariable("suppliers", supplierDataStore.getAll());
        context.setVariable("category", productCategoryDataStore.find(categoryId));
        if(userName != null) {
            context.setVariable("username", userName);
        }
        engine.process("product/index.html", context, resp.getWriter());
        try {
            setupDbManager();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            System.out.println(dbManager.getUserByUserName("asd"));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    private void setupDbManager() throws SQLException {
        dbManager = new ShopDatabaseManager();
        dbManager.setup();
    }

}
