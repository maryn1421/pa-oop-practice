package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderMemoryDao;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.OrderMemory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class OrderMemoryDaoJDBC implements OrderMemoryDao {
    DataSource dataSource;

    public OrderMemoryDaoJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Order order) {
        try (Connection conn = dataSource.getConnection()) {
            int id = order.getUser().getId();
            String sql = "INSERT INTO orders (user_id, items, totalPrice) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.setString(2, order.getCart().toString());
            statement.setInt(3, order.getTotalPrice());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            order.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


 /*
 CREATE TABLE orders (
                     id serial NOT NULL,
                     user_id integer,
                     items text,
                     date timestamp default  current_timestamp
);
  */

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
}
