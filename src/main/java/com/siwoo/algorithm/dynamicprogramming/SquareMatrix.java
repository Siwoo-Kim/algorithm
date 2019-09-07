package com.siwoo.algorithm.dynamicprogramming;

/**
 * Created by sm123tt@gmail.com on 2019-09-07
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class SquareMatrix {


    static class Matrix {
        int[][] matrix;

        public Matrix(int[][] r) {
            this.matrix = r;
        }

        Matrix multiply(Matrix o) {
            int[][] r = new int[this.matrix.length][this.matrix[0].length];
            for (int i=0; i<this.matrix.length; i++) {
                for (int j=0; j<this.matrix[i].length; j++)
                    r[i][j] += this.matrix[i][j] * o.matrix[i][j];
            }
            return new Matrix(r);
        }
    }


}
