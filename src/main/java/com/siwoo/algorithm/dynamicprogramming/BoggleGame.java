package com.siwoo.algorithm.dynamicprogramming;

/**
 * Boggle Game.
 * 5 x 5 크기 격자에서 상하좌우/ 대각선으로 인접한 칸들의
 * 글자들을 이어서 주어진 단어가 존재하는 지를 알아내라.
 *
 * 완전 탐색(Brute Force)
 *  :완전 탐색은 존재하는 모든 경우를 검사한다. 만약 주어진 시간 안에 계산할 수 없다면 다른 설계 패러다임을 사용하라.
 *  가능한 모든 답의 후보를 만드는 과정을 '여러 개의 선택'으로 나눈다. 각 선택은 답의 후보를 만드는 과정의 한 조각이 된다.
 *  그중 하나의 조각을 선택해 답의 일부를 만들고, 나머지 답을 재귀 호출을 통해 완성한다.
 *  조각이 하나밖에 남지 않은 경우, 기저 사례로 선택해 답을 생성하고 처리한다.
 *
 */
public class BoggleGame {

    public static void main(String[] args) {
        BoggleGame boggleGame = new BoggleGame();
        boolean r = boggleGame.hasWord("PRETTY");
        System.out.println(r);
    }

    final static char[][] BOARD = {
            {'U', 'R', 'L', 'P', 'M'},
            {'X', 'P', 'R', 'E', 'T'},
            {'G', 'I', 'A', 'E', 'T'},
            {'X', 'T', 'N', 'Z', 'Y'},
            {'X', 'O', 'Q', 'R', 'S'}
    };

    final static int[] DX = {-1, -1, -1, 1, 1, 1, 0, 0};
    final static int[] DY = {-1, 0, 1, -1, 0, 1, -1, 1};

    private boolean hasWord(String word) {
        boolean r = false;
        for (int y=0; y<8; y++)
            for (int x=0; x<8; x++) {
                r |= hasWord(y, x, word);
                if (r)
                    return true;
            }
        return false;
    }

    /**
     * 5x5 의 보글 게임 판의 해당 위치에서 주어진 단어가 시작하는지를 반환
     * @param y
     * @param x
     * @param word
     * @return
     */
    private boolean hasWord(int y, int x, String word) {
        //BASE CASE: 보드의 범위를 넘어섰다.
        if (!inRange(y, x)) return false;
        //BASE CASE: 첫 단어가 일치하지 않는다.
        if (BOARD[y][x] != word.charAt(0)) return false;
        //BASE CASE: 첫 단어이자 마지막 단어가 일치한다.
        if (word.length() == 1) return true;
        for (int d=0,N=8; d<N; d++) {
            int nextY = y + DY[d], nextX = x + DX[d];
            if (hasWord(nextY, nextX, word.substring(1)))
                return true;
        }
        return false;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < BOARD.length && x >= 0 && x < BOARD[0].length;
    }
}
