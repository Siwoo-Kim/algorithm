package com.siwoo.algorithm.dynamicprogramming;

/**
 * 숫자로 이루어진 삼각형이 주어질 때,
 * 최대 경로의 갯수를 구하여라.
 */

public class CountTrianglePath {

    public int[][] TRIANGLE =
            {
                    {9},
                    {5, 7},
                    {1, 3, 2},
                    {3, 5, 5, 6}
            };

    public static void main(String[] args) {
        CountTrianglePath countTrianglePath = new CountTrianglePath();
        System.out.println(countTrianglePath.count(0, 0));
    }

    int count(int y, int x) {
        if (y == TRIANGLE.length-1) return 1;
        int r = 0;
        if (total(y+1, x+1) >= total(y+1, x)) r += count(y+1, x+1);
        if (total(y+1, x+1) <= total(y+1, x)) r += count(y+1, x);
        return r;
    }

    int total(int y, int x) {
        if (y >= TRIANGLE.length || x >= TRIANGLE[y].length)
            return Integer.MIN_VALUE;
        if (y == TRIANGLE.length-1)
            return TRIANGLE[y][x];
        return Math.max(total(y+1, x), total(y+1, x+1)) + TRIANGLE[y][x];
    }
}
