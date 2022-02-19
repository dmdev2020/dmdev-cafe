package com.dmdev;

import com.dmdev.service.DmdevCafe;

public class ApplicationRunner {

    public static void main(String[] args) {
        new DmdevCafe(10, 5).start();
    }
}
