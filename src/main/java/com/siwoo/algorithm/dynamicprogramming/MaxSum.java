package com.siwoo.algorithm.dynamicprogramming;

/**
 * 1 차원 배열에서 연속된 부분 구간 중 그 합이 최대인 구간을 찾아라.
 *
 */
public class MaxSum {

    public static void main(String[] args) {
        MaxSum maxSum = new MaxSum();
        int[] a = {-7, 4, -3, 6, 3, -8, 3, 4};
        int sum = maxSum.inefficientSum(a);
        //sum = maxSum.fastSum(a);
        sum = maxSum.fastestMaxSum(a);
        System.out.println(sum);

    }

    /**
     * O(N^3)
     * @param a
     * @return
     */
    public int inefficientSum(int[] a) {
        final int N = a.length;
        int r = Integer.MIN_VALUE;
        for (int start=0; start<N; start++) {
            for (int end=start; end<N; end++) {
                int sum = 0;
                for (int i=start; i<end; i++)
                    sum += a[i];
                r = Math.max(r, sum);
            }
        }
        return r;
    }

    /**
     * O(N^2)
     * @param a
     * @return
     */
    public int betterSum(int[] a) {
        final int N = a.length;
        int r = Integer.MIN_VALUE;
        for (int start=0; start<N; start++) {
            int sum = 0;
            for (int end=start; end<N; end++) {
                sum += a[end];
                r = Math.max(r, sum);
            }
        }
        return r;
    }

    public int fastSum(int[] a) {
        return fastSum(a, 0, a.length-1);
    }

    /**
     * O(NlgN)
     * @param a
     * @param low
     * @param high
     * @return
     */
    private int fastSum(int[] a, int low, int high) {
        //BASE CASE: 구간의 길이가 하나인 경우
        if (low == high) return a[low];

        int mid = (high+low) / 2;
        int left=Integer.MIN_VALUE, right=Integer.MIN_VALUE, sum = 0;
        for (int i=mid; i>=low; i--) {
            sum += a[i];
            left = Math.max(sum, left);
        }
        sum = 0;
        for (int i=mid+1; i<=high; i++) {
            sum += a[i];
            right = Math.max(sum, right);
        }
        int subsections = Math.max(
                fastSum(a, low, mid),
                fastSum(a, mid+1, high));
        return Math.max(left + right, subsections);
    }

    /**
     * O(N)
     * @param a
     * @return
     */
    int fastestMaxSum(int[] a) {
        int N = a.length, r = 0, psum = 0;
        for (int i=0; i<N; i++) {
            psum = Math.max(psum, 0) + a[i];
            r = Math.max(psum, r);
        }
        return r;
    }
}
