package com.codecool.shop.controller;


import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Products", urlPatterns = "/products")
public class Products extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {



        String json = gson.toJson(ProductDaoMem.getInstance().getAll());
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }
}