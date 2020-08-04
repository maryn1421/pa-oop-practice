package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.UserDaoMem;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class ShopDatabaseManager {

    private UserDaoMem UserDao;

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        String dbName =  System.getenv("DB_NAME");
        String user = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");
        System.out.println(dbName);

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        System.out.println("Trying to connect");
        dataSource.getConnection().close();
        System.out.println("Connection ok.");

        return dataSource;
    }

    public void setup() throws SQLException {
        DataSource dataSource = connect();
        UserDao = new UserDaoMem(dataSource);

    }
}

/*
CREATE TABLE users (
                       id serial NOT NULL,
                       email text,
                       username text,
                       name text,
                       zip_code text,
                       city text,
                       address text,
                       password text,
                       registration_date timestamp default current_timestamp
);
 */
