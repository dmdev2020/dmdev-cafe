package com.dmdev.csv;

import java.util.List;

public record CashboxRow(Integer id,
                         Integer ordersNumber,
                         Integer orderPriceSum) implements CsvRow {

    public CashboxRow(String[] columns) {
        this(Integer.valueOf(columns[0]), Integer.valueOf(columns[1]), Integer.valueOf(columns[2]));
    }

    @Override
    public List<Object> values() {
        return List.of(id, ordersNumber, orderPriceSum);
    }
}
