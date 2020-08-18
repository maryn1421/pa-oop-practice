package com.practice.app.controller;

import com.google.gson.Gson;
import com.practice.app.config.TemplateEngineUtil;
import com.practice.app.dao.practiceDatabaseManager;
import com.practice.app.model.Exercise;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(urlPatterns = {"/random"})
public class RandomQuestionController extends HttpServlet {
    practiceDatabaseManager dbManager;
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            setupDbManager();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Exercise exercise = null;
        try {
            exercise = dbManager.getRandomExercise();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        String json = gson.toJson(exercise);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();


    }
    private void setupDbManager() throws SQLException {
        dbManager = new practiceDatabaseManager();
        dbManager.setup();
    }

}
