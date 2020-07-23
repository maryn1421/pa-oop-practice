package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoMem implements OrderDao {
    private static OrderDaoMem instance = null;
    private List<Order> data = new ArrayList<>();


    public static OrderDaoMem getInstance() {
        if (instance == null) {
            instance = new OrderDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Order order) {
        order.setId(data.size() + 1);
        data.add(order);
    }
    @Override
    public Order find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Order> getAll() {
        return data;
    }

    @Override
    public List<Order> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Order> getBy(ProductCategory productCategory) {
        return null;
    }
}
