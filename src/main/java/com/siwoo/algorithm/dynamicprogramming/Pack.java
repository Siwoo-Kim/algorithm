package com.siwoo.algorithm.dynamicprogramming;

import sun.awt.windows.WEmbeddedFrame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 여행 짐 싸기.
 *
 * 캐리어의 용량 W 와 각 물건들의 부피(V)와 절박도(N)가 주어질 때
 * 절박도를 최대화할 수 있는 물건들의 목록들을 출력하라.
 *
 */
public class Pack {

    public static int N = 6;
    public static int WEIGHT = 10;
    public static int[] VOLUME = {4, 2, 6, 4, 2, 10};
    public static int[] NEED = {7, 10, 6, 7, 5, 4};

    public static void main(String[] args) {
        Pack pack = new Pack();
        List<Integer> picked = new ArrayList<>();
        pack.pack(0, WEIGHT, picked);
        System.out.println(picked);

    }

    public int pack(int item, int capacity) {
        if (item == N) return 0;
        int r = pack(item + 1, capacity);
        if (capacity >= VOLUME[item])
            r = Math.max(r, pack(item + 1, capacity - VOLUME[item]) + NEED[item]);
        return r;
    }

    public void pack(int item, int capacity, List<Integer> picked) {
        if (item == N) return;
        if (pack(item, capacity) == pack(item+1, capacity) ) {
            pack(item+1, capacity, picked);
        } else {
            picked.add(item);
            pack(item+1, capacity - VOLUME[item] , picked);
        }
    }
}
