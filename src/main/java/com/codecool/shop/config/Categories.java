package com.codecool.shop.config;

import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.dao.implementation.OrderMemoryDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/orders")
public class Categories extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Gson gson = new Gson();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {


        OrderDaoMem orderDataStore = OrderMemoryDaoMem.getInstance();
        System.out.println(orderDataStore.getAll().size());
        List<Order> orders = orderDataStore.getAll();
        JSONObject obj = new JSONObject();

        for (int i = 0; i < orders.size() ; i++) {
            try {
                obj.put(String.valueOf(i),orders.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
       System.out.println(obj);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(obj);
        out.flush();
    }
}



