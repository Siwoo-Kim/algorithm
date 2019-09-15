package com.siwoo.algorithm.dynamicprogramming;

/**
 * Created by sm123tt@gmail.com on 2019-09-14
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class Poly {

    public static void main(String[] args) {
        Poly poly = new Poly();
        System.out.println(poly.poly(4, 1));
    }

    public int poly(int n, int first) {
        if (first == n) return 1;
        int r = 0;
        for (int second=1; second<n-first; second++) {
            int add = second+ first - 1;
            add *= poly(n-first, second);
            r += add;
        }
        return r;
    }
}
