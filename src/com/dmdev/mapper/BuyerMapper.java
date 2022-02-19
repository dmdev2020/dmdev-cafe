package com.dmdev.mapper;

import com.dmdev.csv.BuyerRow;
import com.dmdev.model.Order;
import com.dmdev.model.Product;
import com.dmdev.service.Buyer;

import java.util.List;

public class BuyerMapper implements Mapper<Buyer, BuyerRow> {

    @Override
    public BuyerRow map(Buyer buyer) {
        return new BuyerRow(
            buyer.getId(),
            buyer.getOrders().size(),
            getCaloriesAvg(buyer.getOrders()),
            getOrderPriceAvg(buyer.getOrders())
        );
    }

    private Double getCaloriesAvg(List<Order> orders) {
        return orders.stream()
            .flatMap(order -> order.products().stream())
            .mapToInt(Product::calories)
            .average()
            .orElse(0.0);
    }

    private Double getOrderPriceAvg(List<Order> orders) {
        return orders.stream()
            .flatMap(order -> order.products().stream())
            .mapToInt(Product::price)
            .average()
            .orElse(0.0);
    }
}
