package com.dmdev.util;

import java.util.Random;

public final class RandomUtil {

    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int get(int max) {
        return RANDOM.nextInt(max);
    }
}
