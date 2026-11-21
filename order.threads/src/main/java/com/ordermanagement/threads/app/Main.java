package com.ordermanagement.threads.app;

import com.ordermanagement.processing.factory.ProductFactory;
import com.ordermanagement.processing.model.Product;
import com.ordermanagement.processing.model.Clothing;

import com.ordermanagement.storage.repository.OrderRepository;
import com.ordermanagement.threads.service.OrderThreadService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ProductFactory factory = new ProductFactory();
        OrderRepository repository = new OrderRepository();

        List<Product> products = factory.createProducts();

        products.forEach(repository::addProduct);

        System.out.println("===== УСІ ЗАМОВЛЕННЯ =====");
        repository.showProducts();

        System.out.println("\n===== ФІЛЬТРАЦІЯ ОДЯГУ =====");

        products.stream()
                .filter(product -> product instanceof Clothing)
                .forEach(product ->
                        System.out.println(product.getName()));

        System.out.println("\n===== ОБРОБКА ЗАМОВЛЕНЬ =====");

        OrderThreadService threadService = new OrderThreadService();
        threadService.processOrders(repository.getProducts());
    }
}