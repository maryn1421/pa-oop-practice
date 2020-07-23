package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        Supplier microsoft = new Supplier("microsoft", "digital content and services");
        Supplier sony = new Supplier("sony", "digital content and services");
        Supplier lenovo = new Supplier("Lenovo", "digital content and services");
        Supplier apple = new Supplier("Lenovo", "digital content and services");
        Supplier huawei = new Supplier("Lenovo", "digital content and services");
        Supplier nokia = new Supplier("nokia", "digital content and services");
        supplierDataStore.add(amazon);
        supplierDataStore.add(nokia);
        supplierDataStore.add(apple);
        supplierDataStore.add(huawei);
        supplierDataStore.add(microsoft);
        supplierDataStore.add(sony);
        supplierDataStore.add(lenovo);

        //setting up a new product category
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        ProductCategory console = new ProductCategory("Console", "Hardware", "A personal computer specially to play computer games.");
        ProductCategory phone = new ProductCategory("Phone", "Hardware", "Telecommunication device.");
        ProductCategory television = new ProductCategory("Television", "Hardware", "Telecommunication medium.");
        productCategoryDataStore.add(tablet);
        productCategoryDataStore.add(television);
        productCategoryDataStore.add(phone);
        productCategoryDataStore.add(console);

        //setting up products and printing it
        productDataStore.add(new Product("Amazon Fire", 49.9f, "USD", "Amazon tablet with fantastic price.", tablet, amazon));
        productDataStore.add(new Product("Lenovo IdeaPad", 479, "USD", "Tablet.", tablet, lenovo));
        productDataStore.add(new Product("Amazon Fire HD 8", 89, "USD", "Amazon's latest Fire HD 8 tablet.", tablet, amazon));
        productDataStore.add(new Product("Nokia 3310", 100,"USD","The Best cellphone in the world",phone, nokia));
        productDataStore.add(new Product("XBOX One", 200, "USD", "Microsoft Console", console, microsoft));
        productDataStore.add(new Product("PS5", 800, "USD", "Sony console", console, sony));
        productDataStore.add(new Product("Sony Brawia", 1500, "USD", "Top Sony television", television, sony));
        productDataStore.add(new Product("Iphone Xs", 999, "USD", "Apple Iphone", phone, apple));
       // productDataStore.add(new Product("Apple Ipad mini 4", 699, "USD", "Apple Ipad", tablet, apple));
     //   productDataStore.add(new Product("Huawei Mate 30", 400, "USD", "Huawei phone", phone, huawei));
    }
}
