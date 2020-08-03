package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderMemoryDao;
import com.codecool.shop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderMemoryDaoMem implements OrderMemoryDao {
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
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));

    }

    @Override
    public List<Order> getAll() {
        return data;
    }
}
