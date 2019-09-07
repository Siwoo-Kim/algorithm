package com.siwoo.algorithm.dynamicprogramming;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 모든 숫자가 서로 다른 수열이 주어질 때,
 * 이 수열의 LIS 중 사전순서대로 맨 앞에서 k번째 있는 LIS 를 출력하라.
 * LIS (최대 증가 부분 수열- 우열의 증가 부분 수열 중 가장 긴 것.)
 */
public class Lis {

    private final int N ;
    private final int[] a;
    private final Integer[] c;

    public Lis(int[] ints) {
        this.a = ints;
        N = a.length;
        c = new Integer[N];
        for (int i=0; i<N; i++)
            c[i] = -1;
    }

    public static void main(String[] args) {
        Lis lis = new Lis(new int[]{10,9,2,5,3,7,101,18});
        System.out.println(lis.lengthOfLIS(0));
    }

    private int lengthOfLIS(int start) {
        Integer r = c[start];
        if (r != -1) return r;
        r = 1;
        for (int next=start+1; next<N; next++)
            if (a[start] <= a[next]) {
                r = Math.max(r, lengthOfLIS(next) + 1);
                c[next] = r;
            }
        return r;
    }

}
