package com.dmdev.csv;

import java.util.List;

public record BuyerRow(Integer id,
                       Integer ordersNumber,
                       Double caloriesAvg,
                       Double orderPriceAvg) implements CsvRow {

    public BuyerRow(String[] columns) {
        this(Integer.valueOf(columns[0]), Integer.valueOf(columns[1]), Double.valueOf(columns[2]), Double.valueOf(columns[3]));
    }

    @Override
    public List<Object> values() {
        return List.of(id, ordersNumber, caloriesAvg, orderPriceAvg);
    }
}
