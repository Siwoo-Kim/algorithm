package com.siwoo.algorithm.leetcode;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by sm123tt@gmail.com on 2019-09-11
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class LongestContinuousIncreasingSubsequence {

    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        }
        private int[] nums;
        private int N;
        Integer[] cached;

        public int findLengthOfLCIS(int[] nums) {
            this.nums = nums;
            this.N = nums.length;
            cached = new Integer[nums.length + 1];
            return findLengthOfLCIS();
        }

        private int findLengthOfLCIS() {
            int r = 0;
            for (int start=0; start<N; start++) {
                for (int end=start+1; end<N; end++) {
                    if (nums[start] < nums[end] && nums[end-1] < nums[end])
                        r = Math.max(r, end-start+1);
                    else
                        break;
                }
            }
            return r;
        }

    }
}
