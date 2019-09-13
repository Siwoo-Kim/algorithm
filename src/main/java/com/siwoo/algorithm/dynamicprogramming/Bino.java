package com.siwoo.algorithm.dynamicprogramming;

/**
 * 이항 계수: n개의 서로 다른 물건에서 r개를 선택하는 방법.
 * (n r) = n! / r!(n-r)!
 */

public class Bino {

    public static void main(String[] args) {
        Bino bino = new Bino();
        int r = bino.bino(4, 2);
        System.out.println(r);
    }

    Integer cache[][] = new Integer[30][30];

    int bino(int n, int r) {
        if (r==0 || r==n) return 1;
        if (cache[n][r] != null) return cache[n][r];
        return bino(n-1, r-1) + bino(n-1, r);
    }
}
