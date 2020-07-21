package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.Order;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.List;

public class OrderDaoMem implements OrderDao {
    @Override
    public void add(Order order) {

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
        return null;
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
