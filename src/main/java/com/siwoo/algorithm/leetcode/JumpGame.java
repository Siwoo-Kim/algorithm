package com.siwoo.algorithm.leetcode;

import java.util.Objects;

/**
 * Created by sm123tt@gmail.com on 2019-09-09
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class JumpGame {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean r = solution.canJump(new int[]{3,2,1,0,4});
        System.out.println(r);
    }

    static class Solution {
        Boolean[] cached;
        int[] nums;
        int N;

        public boolean canJump(int[] nums) {
            cached = new Boolean[nums.length];
            this.nums = nums;
            this.N = nums.length;
            return canJump(0);
        }

        private boolean canJump(int current) {
            if (current >= nums.length) return false;
            if (current == nums.length -1) return true;
            if (Objects.nonNull(cached[current]))
                return cached[current];
            boolean r = false;
            for (int i=nums[current]; i>0; i--) {
                if (canJump(current+i)) {
                    r |= true;
                    break;
                }
            }
            return r;
        }
    }

}
