package com.siwoo.algorithm.dynamicprogramming;


import java.util.Objects;

/**
 * 삼각형 위의 최대 경로. TrianglePath
 * 삼각형으로 배치된 자연수들이 주어질 때, 맨 위의 숫자에서 시작해
 * 한 번에 한칸씩 아래로 내려가되 바로 아래 숫자 혹은 오른쪽 아래 숫자로 내려갈 수 있다.
 * 이때 숫자의 합이 최대화되는 경로의 값을 구하여라.
 */
public class TrianglePath {

    public static void main(String[] args) {
        TrianglePath trianglePath = new TrianglePath();
        int r = trianglePath.path(0, 0);
        System.out.println(r);
    }

    int[][] BOARD = {
            {9,},
            {5, 7,},
            {1, 3, 2},
            {3, 5, 5, 6}
    };
    Integer[][] cached = new Integer[BOARD.length][BOARD.length];

    private int path(int y, int x) {
        if (y == BOARD.length-1) return BOARD[y][x];
        if (Objects.nonNull(cached[y][x]))
            return cached[y][x];
        return cached[y][x] = Math.max(
                path(y+1, x) + BOARD[y][x],
                path(y+1, x+1) + BOARD[y][x]);
    }
}
