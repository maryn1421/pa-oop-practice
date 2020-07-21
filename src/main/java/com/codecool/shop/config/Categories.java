package com.codecool.shop.config;

import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
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



@WebServlet("/test")
public class Categories extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // This will store all received articles

    /***************************************************
     * URL: /jsonservlet
     * doPost(): receives JSON data, parse it, map it and send back as JSON
     ****************************************************/

    private Gson gson = new Gson();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        //setting up a new supplier

        ProductCategoryDaoMem productCategoryDaoMem = ProductCategoryDaoMem.getInstance();
        List<ProductCategory> categories = productCategoryDaoMem.getAll();
        JSONObject obj = new JSONObject();
      //  System.out.println(productCategoryDaoMem);
        System.out.println(categories);
        /*categories.forEach(productCategory -> {
            try {
                obj.put("test",productCategory);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        });
         */

        for (int i = 0; i < categories.size() ; i++) {
            try {
                obj.put(String.valueOf(i),categories.get(i));
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



