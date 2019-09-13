package com.siwoo.algorithm.dynamicprogramming;

import java.util.Objects;

/**
 * n x n 크기의 격자에 1~9 까지 정수가 쓰인 게임판에서,
 * 각 칸에 적혀 있는 숫자만큼 아래쪽이나 오른쪽으로 이동할 수 있다.
 * 주어진 게임판에서 시작점에서 끝점을 도달하는 방법이 존재하는 지
 * 계산하라.
 */

public class JumpGame {

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        boolean r = jumpGame.jump(0, 0);
        System.out.println(r);
    }

    //n * n
    public int[][] BOARD = new int[][] {
            {2, 5, 1, 6, 1, 4, 1},
            {6, 1, 1, 2, 2, 9, 3},
            {7, 2, 3, 2, 1, 3, 1},
            {1, 1, 3, 1, 7, 1, 2},
            {4, 1, 2, 3, 4, 1, 2},
            {3, 3, 1, 2, 3, 4, 1},
            {1, 5, 2, 9, 4, 7, 0}
    };

    private Boolean[][] cached = new Boolean[100][100];

    private boolean jump(int y, int x) {
        if (y >= BOARD.length || x >= BOARD.length)
            return false;
        if (y == BOARD.length-1 && x == BOARD.length-1)
            return true;
        if (Objects.nonNull(cached[y][x]))
            return cached[y][x];
        return jump(y+BOARD[y][x], x) || jump(y, x+BOARD[y][x]);
    }

}
