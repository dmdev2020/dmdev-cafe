package com.dmdev.csv;

import java.util.List;

import static java.util.stream.Collectors.joining;

public interface CsvRow {

    String COLUMN_SEPARATOR = ",";

    List<Object> values();

    default String toCsvRow() {
        return values().stream()
            .map(String::valueOf)
            .collect(joining(COLUMN_SEPARATOR));
    }
}
