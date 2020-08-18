package com.codecool.shop.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
       // productDataStore.add(new Product("Apple Ipad mini 4", 699, "USD", "Apple Ipad", tablet, apple));
     //   productDataStore.add(new Product("Huawei Mate 30", 400, "USD", "Huawei phone", phone, huawei));
    }


}
