package com.practice.app.controller;

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
import java.sql.SQLException;


@WebServlet(urlPatterns = {"/"})
public class exerciseController extends HttpServlet {
    practiceDatabaseManager dbManager;

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
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        if (exercise != null){
            context.setVariable("exercise", exercise);
        }
        engine.process("product/index.html", context, resp.getWriter());


    }
    private void setupDbManager() throws SQLException {
        dbManager = new practiceDatabaseManager();
        dbManager.setup();
    }

}
