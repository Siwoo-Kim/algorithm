package com.siwoo.algorithm.dynamicprogramming;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by sm123tt@gmail.com on 2019-09-14
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class Tiling {

    Integer[] cached = new Integer[101];

    public static void main(String[] args) {
        Tiling tiling = new Tiling();
        int r = tiling.tiling(5);
        System.out.println(r);
    }

    int tiling(int n) {
        if (n <= 1) return 1;
        if (Objects.nonNull(cached[n]))
            return cached[n];
        return cached[n] = tiling(n - 2) + tiling(n - 1);
    }
}
