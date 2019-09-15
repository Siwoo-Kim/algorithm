package com.siwoo.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by sm123tt@gmail.com on 2019-09-15
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class LisPrint {

    public static int[] S = {4, 2, 3, 7, 6, 9, 8, 10};
    public static int[] C = new int[101];
    public static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        LisPrint lisPrint = new LisPrint();
        System.out.println(lisPrint.lis());
        System.out.println(Arrays.toString(C));
    }

    private int lis() {
        int r = 0;
        for (int i=0; i<S.length; i++) {
            int cand = lis(i);
            if (r < cand) {
                list = new LinkedList<>();
                r = cand;
                list.addLast(S[i]);
                reconstruct(i, list);
            }
        }
        return r;
    }

    private void reconstruct(int start, LinkedList<Integer> list) {
        if (start != -1) list.addLast(C[start]);
        int next = C[start+1];
        if (next != -1) reconstruct(next, list);
    }

    public int lis(int start) {
        if (start == S.length) return 0;
        int r = 1;
        int bestNext = -1;
        for (int next=start+1; next<S.length; next++) {
            if (S[start] < S[next]) {
                int cand = lis(next) + 1;
                if (r < cand) {
                    r = cand;
                    bestNext = next;
                }
            }
        }
        C[start+1] = bestNext;
        return r;
    }
}
