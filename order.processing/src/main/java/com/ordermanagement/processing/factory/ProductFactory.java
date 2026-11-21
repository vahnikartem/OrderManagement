
package com.ordermanagement.processing.factory;

import com.ordermanagement.processing.model.Clothing;
import com.ordermanagement.processing.model.Electronics;
import com.ordermanagement.processing.model.Product;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class ProductFactory {

    private final Faker faker = new Faker();

    public List<Product> createProducts() {

        List<Product> products = new ArrayList<>();

        Clothing clothing = Clothing.builder()
                .name(faker.commerce().productName())
                .price(faker.number().randomDouble(2, 100, 2000))
                .quantity(faker.number().numberBetween(1, 20))
                .size(faker.options().option("S", "M", "L", "XL"))
                .material(faker.options().option("Cotton", "Wool", "Polyester"))
                .build();

        Electronics electronics = Electronics.builder()
                .name(faker.commerce().productName())
                .price(faker.number().randomDouble(2, 500, 10000))
                .quantity(faker.number().numberBetween(1, 10))
                .warrantyMonths(faker.number().numberBetween(12, 36))
                .brand(faker.company().name())
                .build();

        products.add(clothing);
        products.add(electronics);

        return products;
    }
}
