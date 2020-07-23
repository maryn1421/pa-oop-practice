package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartDaoMem implements CartDao {

    private List<Product> cart = new ArrayList<>();
    private static CartDaoMem instance = null;

    private CartDaoMem() {

    }

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Product product) {
        int productID = product.getId();
        int count = 0;
        for (Product item : cart) {
            if (product.getId() == item.getId()) {
                count++;
            }
        }

        if (count == 0) {
            product.setId(cart.size() + 1);
            cart.add(product);
        }
    }

    @Override
    public List<Product> getCart() {
        return cart;
    }

    @Override
    public int getSize() {
        return cart.size();
    }

    @Override
    public int getTotal() {
        int totalPrice = 0;
        for (Product product : cart) {
            totalPrice += product.getDefaultPrice();
        }

        return totalPrice;
    }

    @Override
    public Product find(int id) {
        return cart.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        cart.remove(find(id));
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return cart.stream().filter(t -> t.getSupplier().equals(supplier)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return cart.stream().filter(t -> t.getSupplier().equals(productCategory)).collect(Collectors.toList());

    }
}
