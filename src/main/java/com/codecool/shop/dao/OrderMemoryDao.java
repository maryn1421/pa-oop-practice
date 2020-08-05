package com.codecool.shop.dao;

import com.codecool.shop.model.Order;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface OrderMemoryDao {
    void add(Order order);
    Order find(int id);
    void remove(int id);
    List<Order> getAll() throws SQLException;

}




