package com.dmdev.model;

public record Product(ProductType type,
                      int calories,
                      int price) {
}
