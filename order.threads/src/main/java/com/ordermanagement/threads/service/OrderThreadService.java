package com.ordermanagement.threads.service;

import com.ordermanagement.processing.model.Product;
import com.ordermanagement.processing.service.OrderProcessor;

import java.util.List;

public class OrderThreadService {

    public void processOrders(List<Product> products) {
        products.forEach(OrderProcessor::processOrder);
    }
}
