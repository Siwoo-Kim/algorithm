package com.siwoo.algorithm.dynamicprogramming;


import com.google.common.primitives.Ints;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 0부터 차례대로 번호 매겨진 n 개의
 * 원소 네 개를 고르는 모든 경우를 출력하라.
 *
 */
public class PrintTicket {

    public static void main(String[] args) {
        PrintTicket printTicket = new PrintTicket();
        //printTicket.print(7);
        printTicket.printRecur(7, new LinkedList<>(), 4);
    }

    private void printRecur(final int N, LinkedList<Number> picked, int toPick) {
        if (toPick == 0) {
            printPicked(Ints.toArray(picked));
            return;
        }
        int el = picked.isEmpty() ? 0 : picked.peekLast().intValue() + 1;
        for (int i=el; i<N; i++) {
            picked.addLast(i);
            printRecur(N, picked, toPick - 1);
            picked.pollLast();
        }
    }

    private void printPicked(int[] picked) {
        System.out.printf("(%d,%d,%d,%d)%n", picked[0], picked[1], picked[2], picked[3]);
    }

    public void print(int n) {
        for (int i=0; i<n; i++)
            for (int j=i+1; j<n; j++)
                for (int k=j+1; k<n; k++)
                    for (int l=k+1; l<n; l++)
                        System.out.printf("(%d,%d,%d,%d)%n", i, j, k, l);
   }
}
