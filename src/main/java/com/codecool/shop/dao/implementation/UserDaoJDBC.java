package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBC implements UserDao {
    DataSource dataSource;
    private static UserDaoJDBC instance = null;
    private List<User> users = new ArrayList<>();

    public UserDaoJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public void add(User user) {
        System.out.println(user.getZipCode());
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO users (email, username, name, zip_code, city, address, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getName());
            statement.setString(4, user.getZipCode());
            statement.setString(5, user.getCity());
            statement.setString(6, user.getAddress());
            statement.setString(7, user.getPassword());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            user.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User find(int id) {
        return users.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        users.remove(find(id));
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}
