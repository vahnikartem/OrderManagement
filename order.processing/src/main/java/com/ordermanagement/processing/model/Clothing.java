package com.ordermanagement.processing.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clothing extends Product {

    private String size;
    private String material;

    @Builder
    public Clothing(String name, double price, int quantity,
                    String size, String material) {
        super(name, price, quantity);
        this.size = size;
        this.material = material;
    }
}
