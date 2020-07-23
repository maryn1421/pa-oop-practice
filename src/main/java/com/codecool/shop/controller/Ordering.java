package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.dao.implementation.OrderMemoryDaoMem;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.OrderMemory;
import com.codecool.shop.model.Product;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = {"/order"})
public class Ordering extends HttpServlet {
    CartDao cartDaoDataStore = CartDaoMem.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("price", cartDaoDataStore.getTotal());
        engine.process("product/Ordering.html", context, resp.getWriter());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      //  System.out.println("request: " + request.getParameter("name") + "  " + request.getParameter("address"));
      //  confirmationEmail("zolnaimaryn1421@gmail.com");
        OrderDaoMem orderDataStore = OrderMemoryDaoMem.getInstance();
        Date date = new Date();
        Order order = new Order(request.getParameter("name"), date, request.getParameter("address"), request.getParameter("paymethod"), request.getParameter("email"));
        List<Product> cart = cartDaoDataStore.getCart();
        orderDataStore.add(order);
        confirmationEmail(order, cart);
        cartDaoDataStore.getCart().clear();

        //System.out.println(orderDataStore.getAll().size());

    }

    private void confirmationEmail(Order order, List<Product> cart) {
        final String username = "246webshop@gmail.com";
        final String password = "szotyilow";
        String email  = order.getEmail();
        String name = order.getName();
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        StringBuilder products = new StringBuilder();
        cart.forEach(product -> {
            String test = product.toString();
            products.append(test).append(" ");
        });

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("your_user_name@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Order confirmation");
            message.setText("Hello " + name+ "! " +
                    "" +
                    "Thanks for ordering from our webshop, here is your order confirmation:" +
                    products.toString() + "" +
                    "If you have any problems/issues/questions feel free to contact us on this email address: The 2-4-6 webshop team :)"
            );

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}



