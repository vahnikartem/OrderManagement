package com.ordermanagement.processing.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Electronics extends Product {

    private int warrantyMonths;
    private String brand;

    @Builder
    public Electronics(String name, double price, int quantity,
                       int warrantyMonths, String brand) {
        super(name, price, quantity);
        this.warrantyMonths = warrantyMonths;
        this.brand = brand;
    }
}
