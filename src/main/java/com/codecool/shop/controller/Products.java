package com.codecool.shop.controller;


import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.google.gson.Gson;
import org.json.JSONArray;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Products", urlPatterns = "/products")
public class Products extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {


        ProductDao productDataStore = ProductDaoMem.getInstance();
        List<Product> all = productDataStore.getAll();
        List<String> list = new ArrayList<String>();
      //  String employeeJsonString = this.gson.toJson(mylist);
        JSONArray jsArray = new JSONArray(all);
        System.out.println(jsArray);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsArray);
        out.flush();
    }
}