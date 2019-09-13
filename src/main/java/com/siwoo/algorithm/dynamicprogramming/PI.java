package com.siwoo.algorithm.dynamicprogramming;


import java.util.function.BinaryOperator;

/**
 * 숫자가 주어질 때, 난이도의 합이 최소하도록 숫자들을
 * 세 자리에서 다섯 자리까지 끊어서 읽을 때,
 * 해당 숫자의 최소 난이도를 계산하라.
 *
 * 난이도:
 *  모든 숫자가 같을 때: 1
 *  숫자가 1씩 단조 증가, 단조 감소: 2
 *  두 개의 숫자가 번갈아 등장: 4
 *  숫자가 등차 수열: 5
 *  이 외의 모든 경우: 10
 */

public class PI {

    String A;
    private int N;

    public static void main(String[] args) {
        PI pi = new PI();
        pi.A = "12563939";
        pi.N = pi.A.length();
        System.out.println(pi.classify(0, 3));
        System.out.println(pi.classify(4, pi.A.length()-1));
        System.out.println(pi.memorize(0));
    }

    public int memorize(int begin) {
        if (begin == N) return 0;
        int r = 9999;
        for (int i=begin; i<N; i++)
            for (int L=3; L<=5; L++) {
                if (i + L <= N)
                    r = Integer.min(r,classify(begin, begin+L) + memorize(begin+L));
            }
        return r;
    }

    int classify(int begin, int end) {
        String s = A.substring(begin, end);
        //모든 숫자가 같을 때: 1
        boolean same = true;
        for (int i=0; i<s.length(); i++)
            if (s.charAt(i) != s.charAt(0))
                same = false;
        if (same) return 1;
        //숫자가 등차 수열: 5
        boolean progressive = true;
        for (int i=0; i<s.length()-1; i++)
            if (s.charAt(i)-s.charAt(i+1) != s.charAt(0)-s.charAt(i+1))
                progressive = false;
        //1씩 단조 증가: 2
        if (progressive && Math.abs(s.charAt(0) - s.charAt(1)) == 1)
            return 2;
        boolean alternating = true;
        for (int i=0; i<s.length(); i++)
            if (s.charAt(i) != s.charAt(i%2))
                alternating = false;
        if (alternating) return 4;
        if (progressive) return 5;
        return 10;
    }
}
