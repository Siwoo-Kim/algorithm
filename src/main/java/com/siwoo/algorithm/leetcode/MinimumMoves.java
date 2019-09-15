package com.siwoo.algorithm.leetcode;

import com.siwoo.algorithm.dynamicprogramming.QuickSort;

import java.util.Arrays;

public class MinimumMoves {

    static class Solution {

        public static void main(String[] args) {
            Solution solution = new Solution();
            int r = solution.minMoves(new int[]{1, 2, 3, 4});
            System.out.println(r);
        }

        public int minMoves(int[] nums) {
            Arrays.sort(nums);
            int min = nums[0], r = 0;
            for (int n: nums) {
                r += n - min;
            }
            return r;
        }

    }
}
