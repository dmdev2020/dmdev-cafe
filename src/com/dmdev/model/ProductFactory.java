package com.dmdev.model;

public final class ProductFactory {

    private ProductFactory() {
    }

    public static Product get(ProductType type) {
        return switch (type) {
            case STEAK -> new Product(ProductType.STEAK, 500, 10);
            case SALAD -> new Product(ProductType.SALAD, 50, 5);
            case POTATO -> new Product(ProductType.POTATO, 300, 3);
            case COLA -> new Product(ProductType.COLA, 25, 2);
            case ICE_CREAM -> new Product(ProductType.ICE_CREAM, 150, 4);
        };
    }
}
