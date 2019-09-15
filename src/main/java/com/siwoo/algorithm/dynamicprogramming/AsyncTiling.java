package com.siwoo.algorithm.dynamicprogramming;

public class AsyncTiling {

    public static void main(String[] args) {
        AsyncTiling tiling = new AsyncTiling();
        System.out.println(tiling.async(4));
    }

    /**
     * width 가 짝수인 경우
     * @param width
     * @return
     */
    public int async(int width) {
        if (width % 2 == 1)
            return tiling(width) - tiling(width/2);
        int r = tiling(width);
        r -= tiling(width / 2);
        r -= tiling(width/2 -1);
        return r;
    }

    public int tiling(int width) {
        if (width <= 1) return 1;
        return tiling(width-1) + tiling(width-2);
    }
}
