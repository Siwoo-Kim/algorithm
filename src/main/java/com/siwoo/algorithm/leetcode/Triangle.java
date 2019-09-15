package com.siwoo.algorithm.leetcode;

import java.util.List;
import java.util.Objects;

public class Triangle {
    static class Solution {
        List<List<Integer>> T;
        Integer[][] cached;

        public int minimumTotal(List<List<Integer>> triangle) {
            this.T = triangle;
            cached = new Integer[T.size()][T.size()];
            return minimumTotal(0, 0);
        }

        private int minimumTotal(int y, int x) {
            if (Objects.nonNull(cached[y][x]))
                return cached[y][x];
            if (y == T.size() - 1)
                return T.get(y).get(x);
            return cached[y][x] = Math.min(minimumTotal(y+1, x+1), minimumTotal(y+1, x)) + T.get(y).get(x);
        }
    }
}
