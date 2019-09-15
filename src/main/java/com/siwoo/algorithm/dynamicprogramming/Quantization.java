package com.siwoo.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 *  양자화
 *  1000 이하의 자연수로 구성된 수열을 s 가지의 자연수만을 사용하여 양자화하려 한다.
 *  수열과 s 가 주어질 때, 가능한 한 오차 제곱의 합의 최소치를 계산하라.
 *
 */
public class Quantization {

    int[] A = {1, 4, 6, 744, 755, 777, 890, 890, 902};
    int N = A.length;
    int[] pSum = new int[N+1];
    int[] pSqSum = new int[N+1];


    void precalc() {
        Arrays.sort(A);
        pSum[0] = A[0];
        pSqSum[0] = A[0] * A[0];
        for (int next=1; next<N; next++) {
            pSum[next] = pSum[next-1] + A[next];
            pSqSum[next] = pSqSum[next-1] + A[next] * A[next];
        }
    }

    int minError(int lo, int hi) {
        int sum = pSum[hi] - (lo == 0 ? 0: pSum[lo-1]);
        int sqSum = pSqSum[hi] - (lo == 0 ? 0: pSqSum[lo-1]);
        int m = (int)(0.5 + (double) sum / (hi - lo + 1));
        int r = sqSum - 2 * m * sum + m * m * (hi - lo + 1);
        return r;
    }

    int quantize(int from, int parts) {
        if (from == N) return 0;
        if (parts == 0) return Integer.MAX_VALUE;
        int r = 999999;
        for (int partSize=1; from+parts<=N; ++partSize)
            r = Math.min(r, minError(from, from+parts-1) + quantize(from + partSize, parts-1));
        return r;
    }
}
