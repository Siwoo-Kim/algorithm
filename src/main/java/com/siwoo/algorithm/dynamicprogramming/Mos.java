package com.siwoo.algorithm.dynamicprogramming;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 모스 부호는 장점은 (- 긴신호), 단점은 (o 짧은신호) 로 이루어져 있다.
 * n 개의 장점과 m 개의 단점으로 구성된 모든 신호를 담는 사전 (사전순으로 정렬된) 이 있다고 가정할 때,
 * 이 사전의 k 번째 신호를 출력하라
 *
 */

public class Mos {

    private int skip = 3;
    private int bino[][] = new int[201][201];

    public static void main(String[] args) {
        Mos mos = new Mos();
        mos.calcBino();
        mos.mos(3, 3, "");
        System.out.println(mos.bino(8, 2));
    }

    public void mos(int n, int m, String s) {
        if (skip < 0) return;
        if (n == 0 && m == 0) {
            if (skip == 0)
                System.out.println(s);
            skip--;
            return;
        }
        if (bino[n+m][n] <= skip) {
            skip -= bino[n+m][n];
            return;
        }
        if (n > 0) mos(n-1, m, s+"-");
        if (m > 0) mos(n, m-1, s+"o");
    }

    void calcBino() {
        for (int i=0; i<=200; i++) {
            bino[i][0] = bino[i][i] = 1;
            for (int j=1; j<i; j++) {
                bino[i][j] = bino[i-1][j-1] + bino[i-1][j];
            }
        }
    }

    int bino(int n, int r) {
        if (r == 0 || n == r) return 1;
        return bino(n-1, r-1) + bino(n-1, r);
    }
}
