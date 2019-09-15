package com.siwoo.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sm123tt@gmail.com on 2019-09-15
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class PascalsTriangle2 {

    static class Solution {
        private int R = 3;

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] r = solution.getRow(1, new int[]{});

        }

        private static List<Integer> asList(int[] row) {
            List<Integer> r = new ArrayList<>();
            for (int e: row)
                r.add(e);
            return r;
        }

        public int[] getRow(int row, int[] before) {
            if (row > R) return before;
            int[] rows = new int[row];
            rows[0] = 1;
            rows[row-1] = 1;
            for (int i=1; i<row-1; i++) {
                rows[i] = before[i-1] + before[i];
            }
            return getRow(row+1, rows);
        }
    }
}
