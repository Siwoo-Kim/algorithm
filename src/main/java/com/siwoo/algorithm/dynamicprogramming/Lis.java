package com.siwoo.algorithm.dynamicprogramming;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 최대 증가 부분 수열 (LIS, Longest Increasing Subsequence).
 *
 * S의 부분 수열이란 S에서 0개 이상의 숫자를 지우고 남은 수열을 의미한다.
 * 부분 수열에 포함된 숫자들이 순 증가하면, 이 부분 수열을 증가 부분 수열이라 한다.
 * 주어진 수열의 증가 부분 수열 중 가장 긴 것을 찾아라 (순 증가 수열 아님).
 *
 */
public class Lis {

    int[] S = new int[]{10,9,2,5,3,7,101,18};
    int N = S.length;
    Integer[] cached = new Integer[N];

    public static void main(String[] args) {
        Lis lis = new Lis();
        int r = lis.lis();
        System.out.println(r);
    }

    private int lis() {
        int r = 0;
        for (int i=0; i<N; i++)
            r = Math.max(lis(i), r);
        return r;
    }

    private int lis(int start) {
        if (Objects.nonNull(cached[start]))
            return cached[start];
        int r = 1;
        for (int next=start+1; next<N; next++)
            if (S[start] < S[next])
                r = Math.max(r, lis(next) + 1);
        return cached[start] = r;
    }

    public int lis(int[] S) {
        if (S.length == 0) return 0;
        int r = 0;
        for (int start=0; start<S.length; start++) {
            List<Integer> A = new ArrayList<>();
            for (int next=start+1; next<S.length; next++) {
                if (S[start] < S[next])
                    A.add(S[next]);
            }
            r = Math.max(r, lis(Ints.toArray(A)) + 1);
        }
        return r;
    }

}
