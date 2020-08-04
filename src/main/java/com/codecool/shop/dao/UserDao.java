package com.codecool.shop.dao;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void add(User user);
    User find(int id) throws SQLException, ClassNotFoundException;
    void remove(int id) throws SQLException, ClassNotFoundException;

}
