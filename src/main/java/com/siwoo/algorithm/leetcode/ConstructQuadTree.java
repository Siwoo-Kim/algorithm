package com.siwoo.algorithm.leetcode;

public class ConstructQuadTree {
    private static int[][] grid = {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};

    public static void main(String[] args) {
        ConstructQuadTree constructQuadTree = new ConstructQuadTree();
        constructQuadTree.construct(grid);
    }
    public Node construct(int[][] grid) {
        this.grid = grid;
        return construct(0, 0, grid.length);
    }

    public Node construct(int y, int x, int size) {
        boolean leaf = true;
        for (int dy=0; dy<size; dy++) {
            for (int dx=0; dx<size; dx++)
                if (grid[y][x] != grid[y+dx][x+dx]) {
                    leaf = false;
                    break;
                }
        }

        Node node = null;
        if (leaf)
            node = new Node(grid[y][x] == 1, true, null, null, null, null);
        else {
            int half = size / 2;
            Node tl = construct(y, x, half);
            Node tr = construct(y, x+half, half);
            Node bl = construct(y+half, x, half);
            Node br = construct(y+half, x+half, half);
            node = new Node(false, false, tl, tr, bl, br);
        }
        return node;
    }
}
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};