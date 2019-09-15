package com.siwoo.algorithm.dynamicprogramming;


import java.util.LinkedList;

/**
 * N-1 동료 병사와 조세푸스가 원형으로 선 채 순서대로 자살하기로 결심했다.
 * 한 사람이 자살하면, 다음에는 그 사람으로부터 시계 방향 k번째 사람이 자살을 시작했고,
 * 마지막 두 명은 마음을 바꿔 항복했다 한다.
 * 이때 조세푸스가 마지막 두 명 중 하나가 되기 위해선 조세푸스는 첫 번째 자살 병사로부터 몇번째
 * 자리에 있어야 할까?
 *
 */
public class Josephus {

    public static void main(String[] args) {
        Josephus josephus = new Josephus();
        josephus.josephus(6, 3);
    }
    public LinkedList<Integer> josephus(int N, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=1; i<=N; i++) list.add(i);
        int kill = 0;
        while (N > 2) {
            N--;
            list.remove(kill);
            for (int i=0; i<K-1; i++) {
                kill++;
                if (kill == list.size()) kill = 0;
            }
        }
        return list;
    }
}
