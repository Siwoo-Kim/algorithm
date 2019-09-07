package com.siwoo.algorithm.dynamicprogramming;

import java.util.Objects;

/**
 * 게임판 덮기. Board Cover
 * 검은 칸과 흰 칸으로 구성된 격자 모양의 H x W 게임판에
 * 이 중 모든 흰 칸을 세 칸짜리 L 자 모양의 블록으로 덮을 시,
 * 가능한 경우의 수를 계산하라.
 *
 * 덮을 L 자 모양 블럭은 자유롭게 회전할 수 있다.
 */
public class BoardCover {

    public static void main(String[] args) {
        BoardCover boardCover = new BoardCover();
        int r = boardCover.cover();
        System.out.println(r);
    }

    public static Integer[][] BOARD = {
        {null, 0, 0, 0, 0, 0, null },
        {null, 0, 0, 0, 0, 0, null },
        {null, null, 0, 0, null, null, null },
    };

    //(Y,X)
    public static int[][][] COVER = {
        { {0, 0}, {1, 0}, {0, 1} },
        { {0, 0}, {0, 1}, {1, 1} },
        { {0, 0}, {1, 0}, {1, 1} },
        { {0, 0}, {1, 0}, {1, -1} },
    };

    private int cover() {
        int y=-1, x=-1;
        for (int i=0; i<BOARD.length; i++) {
            for (int j=0; j<BOARD[i].length; j++) {
                if (Objects.nonNull(BOARD[i][j]) && BOARD[i][j] == 0) {
                    y = i;
                    x = j;
                    break;
                }
            }
            if (y != -1) break;
        }
        if (y == -1) return 1;
        int r = 0;
        for (int type=0; type<4; type++) {
            if (set(y, x, type, 1))
                r += cover();
            set(y, x, type, -1);
        }
        return r;
    }

    private boolean set(int y, int x, int type, int delta) {
        boolean ok = true;
        for (int i=0; i<3; i++) {
            final int ny = y + COVER[type][i][0];
            final int nx = x + COVER[type][i][1];
            if (ny < 0 || ny >= BOARD.length || nx < 0 || nx >= BOARD[0].length || Objects.isNull(BOARD[ny][nx]))
                ok = false;
            else if ((BOARD[ny][nx] += delta) > 1)
                ok = false;
        }
        return ok;
    }
}
