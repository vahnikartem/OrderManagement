package com.ordermanagement.processing.service;

import com.ordermanagement.processing.model.Product;
import com.ordermanagement.processing.exception.InvalidOrderException;

public class OrderProcessor<T extends Product> {

    private T product;

    public OrderProcessor(T product) {
        this.product = product;
    }

    public void process() throws InvalidOrderException {

        if (product == null) {
            throw new InvalidOrderException("Товар не заданий");
        }

        if (product.getName() == null || product.getName().isEmpty()) {
            throw new InvalidOrderException("Назва товару не може бути порожньою");
        }

        if (product.getPrice() < 0 || product.getQuantity() <= 0) {
            throw new InvalidOrderException("Некоректні дані товару");
        }

        System.out.println("Обробка замовлення: " + product.getName());
        System.out.println("Ціна: " + product.getPrice());
        System.out.println("Кількість: " + product.getQuantity());
        System.out.println("-------------------------");
    }

    public T getProduct() {
        return product;
    }

    public static void processOrder(Product product) {

        Runnable orderTask = () -> {
            try {
                OrderProcessor<Product> processor =
                        new OrderProcessor<>(product);

                processor.process();

            } catch (InvalidOrderException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        };

        new Thread(orderTask).start();
    }
}
