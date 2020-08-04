package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.UserDaoJDBC;
import com.codecool.shop.model.User;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class ShopDatabaseManager {
     UserDaoJDBC userDao;

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        String dbName =  System.getenv("DB_NAME");
        String user = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        dataSource.getConnection().close();

        return dataSource;
    }

    public void setup() throws SQLException {
        DataSource dataSource = connect();
        userDao = new UserDaoJDBC(dataSource);

    }
    public void registerUser(User user){
        userDao.add(user);
    }

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> all = userDao.getAll();
        return all;
    }
    public User getUserById(int id) throws SQLException, ClassNotFoundException {
        return userDao.find(id);
    }
    public User getUserByUserName(String name) throws SQLException, ClassNotFoundException {
        return userDao.getUserByUserName(name);
    }

}
