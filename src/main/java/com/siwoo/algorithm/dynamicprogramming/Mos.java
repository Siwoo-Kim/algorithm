package com.siwoo.algorithm.dynamicprogramming;

/**
 * 모스 부호는 장점은 (- 긴신호), 단점은 (o 짧은신호) 로 이루어져 있다.
 * n 개의 장점과 m 개의 단점으로 구성된 모든 신호를 담는 사전 (사전순으로 정렬된) 이 있다고 가정할 때,
 * 이 사전의 k 번째 신호를 출력하라
 *
 */

public class Mos {

    private int skip;

    public Mos(int skip) {
        this.skip = skip;
    }

    public static void main(String[] args) {
        Mos mos = new Mos(3);
        //mos.mos(3, 2);
        mos.mosSkip(3, 2);
    }

    void mos(int n, int m) {
        mos(n, m, "");
    }

    void mosSkip(int n, int m) {
        mosSkip(n, m, "");
    }

    private void mosSkip(int n, int m, String s) {
        if (n == 0 && m == 0) {
            skip--;
            if (skip == 0)
                System.out.println(s);
            return;
        }
        if (n > 0) mosSkip(n-1, m, s + '-');
        if (m > 0) mosSkip(n, m-1, s + 'o');
    }

    /**
     *
     * @param n 더 필요한 장점의 갯수
     * @param m 더 필요한 단점의 갯수
     * @param s 지금까지 만든 신호
     */
    void mos(int n, int m, String s) {
        if (n == 0 && m == 0)
            System.out.println(s);
        if (n > 0) mos(n-1, m, s + "-");
        if (m > 0) mos(n, m-1, s + "o");
    }
}
