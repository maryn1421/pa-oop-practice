package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderMemoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.OrderMemory;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public Order find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Order> getAll() throws SQLException {
        Connection conn = dataSource.getConnection();
        Statement stm;
        stm = conn.createStatement();
        String sql = "Select * From orders join users on orders.user_id=users.id";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<Order> orderList = new ArrayList<>();
        while (rst.next()) {
            User u = new User(rst.getString("name"),
                    rst.getString("email"),
                    rst.getString("username"),
                    rst.getString("zip_code"),
                    rst.getString("city"),
                    rst.getString("address"),
                    rst.getString("password"));
            String items = rst.getString("items");
            List<Product> products = getProducts(items);
            System.out.println(products);
            Order e = new Order(rst.getString("name"),rst.getDate("date"),rst.getString("address"),"paypal", rst.getString("email"), u, products );
            e.setId(orderList.size() + 1);
            orderList.add(e);
        }
        return orderList;
    }
    private List<Product> getProducts(String items){
        ProductDao productDao = ProductDaoMem.getInstance();
        List<Product> products = new ArrayList<>();
        items = items.substring(1, items.length() - 1);
        String[] split = items.split(", ");
        System.out.println(Arrays.toString(split));
        List<String> ids = new ArrayList<>();
        List<String> list = Arrays.asList(split);
        list.forEach(item ->{
            if (item.contains("id:")){
                ids.add(item);
            }
        });
        ids.forEach(id ->{
            products.add(productDao.find(Integer.parseInt(id.replaceAll("[\\D]", ""))));
        });
        return products;
    }

    public List<Order> getOrderByUser(String userName) throws SQLException {
        List<Order> orders = new ArrayList<>();
        List<Order> all = getAll();
        all.forEach(order -> {
            if (order.getUser().getUsername().equals(userName)){
                orders.add(order);
            }
        });
    return orders;
    }
    }
