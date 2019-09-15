package com.siwoo.algorithm.leetcode;

/**
 * Created by sm123tt@gmail.com on 2019-09-14
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class HouseRobber {

    static class Solution {

        private static int[] nums = {2,1,1,2};

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.rob());
        }

        private int rob() {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            if (nums.length == 2) return Math.max(nums[0], nums[1]);
            int r = 0;
            nums[1] = Math.max(nums[0], nums[1]);
            for (int start=2; start<nums.length; start++) {
                nums[start] = Math.max(nums[start-1], nums[start] + nums[start-2]);
            }
            return nums[nums.length - 1];
        }

    }
}
