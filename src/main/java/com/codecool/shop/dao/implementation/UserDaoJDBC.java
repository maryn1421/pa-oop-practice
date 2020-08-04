package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBC implements UserDao {
    DataSource dataSource;
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
    public User find(int id) throws SQLException, ClassNotFoundException {
        return getAll().stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) throws SQLException, ClassNotFoundException {
        users.remove(find(id));
    }

    public List<User> getAll() throws ClassNotFoundException, SQLException {
        Connection conn = dataSource.getConnection();
        Statement stm;
        stm = conn.createStatement();
        String sql = "Select * From users";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<User> customerList = new ArrayList<>();
        while (rst.next()) {
            User e = new User(rst.getString("name"), rst.getString("email"), rst.getString("username"), rst.getString("zip_code"), rst.getString("city"), rst.getString("address"), rst.getString("password"));
            e.setId(customerList.size() + 1);
            customerList.add(e);
        }
        return customerList;
    }

    public User getUserByUserName(String name) throws SQLException, ClassNotFoundException {
        return getAll().stream().filter(t -> t.getName().equals(name)).findFirst().orElse(null);
    }
}
