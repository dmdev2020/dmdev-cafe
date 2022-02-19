package com.dmdev.job;

import com.dmdev.csv.CsvRow;
import com.dmdev.mapper.BuyerMapper;
import com.dmdev.service.Buyer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class BuyerStatsJob implements Runnable {

    private final BuyerMapper buyerMapper = new BuyerMapper();
    private final List<Buyer> buyers;
    private final Path buyerStatsPath;

    public BuyerStatsJob(List<Buyer> buyers, Path buyerStatsPath) {
        this.buyers = buyers;
        this.buyerStatsPath = buyerStatsPath;
    }

    @Override
    public void run() {
        try {
            var csvRows = buyers.stream()
                .map(buyerMapper::map)
                .map(CsvRow::toCsvRow)
                .toList();
            Files.write(buyerStatsPath, csvRows, CREATE, TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
