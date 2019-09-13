package com.siwoo.algorithm.leetcode;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
    static class Solution {

        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.generate(5);
        }

        public List<List<Integer>> generate(int numRows) {
            return generate(1, numRows, new ArrayList<>());
        }

        private List<List<Integer>> generate(int row, int numRows, List<List<Integer>> lists) {
            if (row == numRows+1) return lists;
            int[] r = new int[row];
            int start = 0;
            int end = r.length - 1;
            r[start] = 1;
            r[end] = 1;
            List<Integer> beforeRow = lists.isEmpty() ? Collections.emptyList(): lists.get(row-2);
            for (int i=0; i<end && i<lists.size()-1; i++) {
                r[i+1] = beforeRow.get(i) + beforeRow.get(i+1);
            }
            lists.add(asList(r));
            return generate(row+1, numRows, lists);
        }

        private static List<Integer> asList(int[] a) {
            List<Integer> r = new ArrayList<>();
            for (int e: a)
                r.add(e);
            return r;
        }
    }
}
