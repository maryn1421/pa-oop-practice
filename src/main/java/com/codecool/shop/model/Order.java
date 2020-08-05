package com.codecool.shop.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



public class Order extends BaseModel {
    private Date date;
    private String address;
    private String payMethod;
    private String email;
    private User user;
    private List<Product
            > cart;

    public User getUser() {
        return user;
    }

    public List<Product> getCart() {
        return cart;
    }

    public Order(String name, Date date, String address, String payMethod, String email, User user, List<Product> cart) {
        super(name);
        this.date = date;
        this.address = address;
        this.payMethod = payMethod;
        this.email = email;
        this.user = user;
        this.cart = cart;
    }

    public Date getDate(){
        return date;
    }

    public String getAddress(){
        return address;
    }

    public String getPayMethod(){
        return payMethod;
    }
    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "address: %3$s, " +
                        "date: %4$s, ",
                this.id,
                this.name,
                this.address,
                strDate);
    }

    public int getTotalPrice(){
        return cart.stream().mapToInt(item -> (int) item.getDefaultPrice()).sum();
    }

    public String getEmail() {
        return email;
    }
}
