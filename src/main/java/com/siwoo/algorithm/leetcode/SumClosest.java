package com.siwoo.algorithm.leetcode;

public class SumClosest {

    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.threeSumClosest(new int[]{1, 1, -1, -1, 3}, 3));
        }

        public int threeSumClosest(int[] nums, int target) {
            int partialSum = 0;
            for (int i=0; i<2; i++)
                partialSum += nums[i];
            int r = 9999;
            for (int i=2; i<nums.length; i++) {
                partialSum += nums[i];
                int diff = Math.abs(partialSum - target);
                r = diff < Math.abs(r - target) ? partialSum: r;
                partialSum -= nums[i-2];
            }
            return r;
        }
    }
}
