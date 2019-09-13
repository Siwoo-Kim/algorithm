package com.siwoo.algorithm.dynamicprogramming;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by sm123tt@gmail.com on 2019-09-13
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class Jlis {

    public static void main(String[] args) {
        Jlis jlis = new Jlis();
        System.out.println(jlis.jlis(0, 0));
    }

    public int[] A = {10, 20, 30};
    public int[] B = {10, 20, 30, 1, 2};
    public Integer[][] cached = new Integer[A.length+1][B.length+1];

    public int jlis(int indexA, int indexB) {
        if (Objects.nonNull(cached[indexA][indexB]))
            return cached[indexA][indexB];
        int maxElement = Math.max(A[indexA], B[indexB]);
        int r = 2;
        for (int nextA=indexA+1; nextA<A.length; nextA++)
            if (maxElement < A[nextA])
                r = Integer.max(r, jlis(nextA, indexB) + 1);
        for (int nextB=indexB+1; nextB<B.length; nextB++)
            if (maxElement < B[nextB])
                r = Integer.max(r, jlis(indexA, nextB) + 1);
        return cached[indexA][indexB] = r;
    }

    void concat() {
        for (int indexA=0; indexA<A.length; indexA++)
            for (int indexB=0; indexB<B.length; indexB++) {
                int[] C = new int[A.length + B.length];
                int indexC = 0;
                for (int i=0; i<=indexA; i++) C[indexC++] = A[i];
                for (int i=0; i<=indexB; i++) C[indexC++] = B[i];
                System.out.println(Arrays.toString(C));
            }
    }
}
