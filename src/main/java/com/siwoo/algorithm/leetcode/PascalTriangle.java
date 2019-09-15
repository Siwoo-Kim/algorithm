package com.siwoo.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    static class Solution {
        private int ROWS = 5;
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.asList(solution.generate2(1, new int[5][5])));
        }

        private int[][] generate2(int row, int[][] rows) {
            if (row > ROWS) return rows;
            int[] r = new int[row];
            r[0] = r[row-1] = 1;
            for (int i=1; i<row-1; i++) {
                r[i] = rows[row-2][i-1] + rows[row-2][i];
            }
            rows[row-1] = r;
            return generate2(row+1, rows);
        }

        private List<List<Integer>> asList(int[][] a) {
            List<List<Integer>> list = new ArrayList<>();
            for (int[] row : a) {
                List<Integer> rRow = new ArrayList<>();
                for (int i: row) {
                    rRow.add(i);
                }
                list.add(rRow);
            }
            return list;
        }

        public List<List<Integer>> generate(int numRows) {
            if (numRows == 0) return new ArrayList<>();
            int[][] r = new int[numRows][numRows];
            for (int i=0; i<numRows; i++) {
                r[i] = new int[i+1];
                r[i][0] = 1;
                r[i][i] = 1;
                for (int j=1; j<r[i].length-1; j++) {
                    r[i][j] = r[i-1][j-1] + r[i-1][j];
                }
            }
            List<List<Integer>> list = new ArrayList<>();
            for (int[] row : r) {
                List<Integer> rRow = new ArrayList<>();
                for (int i: row) {
                    rRow.add(i);
                }
                list.add(rRow);
            }
            return list;
        }

    }
}
