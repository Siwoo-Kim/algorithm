package com.siwoo.algorithm.dynamicprogramming;

/**
 * 분할 정복을 이용하여 행렬의 거듭 제곱을 구현하라.
 */
public class Matrix {

    public static void main(String[] args) {
        Matrix m1 = new Matrix(new int[][]{
                {1, 2},
                {3, 4}
        });
        Matrix m3 = Matrix.pow(m1, 2);

    }
    private final int[][] matrix;
    private final int YN;
    private final int XN;

    public Matrix(int[][] m) {
        this.matrix = m.clone();
        this.YN = m.length;
        this.XN = m[0].length;
    }

    public Matrix multiply(Matrix o) {
        int[][] r = new int[YN][XN];
        for (int y=0; y<YN; y++)
            for (int x=0; x<XN; x++)
                for (int c=0; c<YN; c++)
                    r[y][x] += matrix[y][c] * o.matrix[c][x];
        return new Matrix(r);
    }

    public static Matrix pow(Matrix m, int p) {
        if (p == 1) return new Matrix(m.matrix);
        if (p % 2 == 1) return pow(m, p-1).multiply(m);
        Matrix half = pow(m, p / 2);
        return half.multiply(half);
    }
}
