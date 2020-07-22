package com.codecool.shop.model;

import java.util.Date;
import java.util.List;

public class Order extends BaseModel {
    public Order(String name, Date date, String address, String payMethod) {
        super(name);
    }


}
