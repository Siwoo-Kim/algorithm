package com.siwoo.algorithm.leetcode;

import java.util.Objects;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class MinimumPath {
    private Integer[][] visited;

    public int minPathSum(int[][] grid) {
        visited = new Integer[grid.length][grid[0].length];
        int r = minPathSum(grid, 0, 0);
        return r;
    }

    private int minPathSum(int[][] grid, int y, int x) {
        if (y >= grid.length || x >= grid[y].length)
            return Integer.MAX_VALUE;
        if (y == grid.length-1 && x == grid[y].length-1)
            return grid[y][x];
        if (Objects.nonNull(visited[y][x]))
            return visited[y][x];
        int d = minPathSum(grid, y+1, x);
        int r = minPathSum(grid, y, x+1);
        visited[y][x] = grid[y][x] = Math.min(d, r);
        return visited[y][x];
    }

}

