package com.ordermanagement.storage.repository;

import com.ordermanagement.processing.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void showProducts() {
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }
}
