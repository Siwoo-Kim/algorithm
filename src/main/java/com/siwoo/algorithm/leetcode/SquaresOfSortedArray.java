package com.siwoo.algorithm.leetcode;

import java.util.Arrays;
import java.util.Objects;

public class SquaresOfSortedArray {


    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        }

        public int[] sortedSquares(int[] A) {
            int[] a = new int[A.length];
            for (int i=0; i<A.length; i++) {
                a[i] = (int) Math.pow(A[i], 2);
            }
            Arrays.sort(a);
            return a;
        }
    }
}
