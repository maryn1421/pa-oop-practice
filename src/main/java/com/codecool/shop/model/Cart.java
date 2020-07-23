package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cart;

    public List<Product> getCart() {
        return this.cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    public void addCartElement(Product product) {
        product.setId(cart.size() + 1);
        this.cart.add(product);
    }


}
