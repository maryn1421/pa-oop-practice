package com.codecool.shop.model;

public class User extends BaseModel {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String zipCode;
    private String City;
    private String Address;
    private String password;

    public User(String name, String email, String username, String zipCode, String city, String address, String password) {
        super(name);
        this.email = email;
        this.username = username;
        this.zipCode = zipCode;
        City = city;
        Address = address;
        this.password = password;
    }
}
