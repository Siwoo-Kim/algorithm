package com.siwoo.algorithm.dynamicprogramming;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 소풍.
 *  소풍 때 학생들을 두 명씩 짝을 지어 이동하려 할 때,
 *  서로 친구인 학생들끼리만 짝을 지으려고 한다.
 *
 *  학생의 숫자와 친구의 여부가 주어질 때
 *  학생들을 짝 지을 수 있는 방법의 수를 계산하라.
 *
 *  완전 탐색과 중복.
 *      :완전 탐색에서는 중복을 다루는 경우가 흔하다.
 *      이 상황을 해결하기 위해서는 특정 형태를 갖는 답만 세는 것이다. (사전순으로만 답을 센다)
 */
public class Picnic {

    public static void main(String[] args) {
        Picnic picnic = new Picnic();
        int r = picnic.countPairings(new boolean[N]);
        System.out.println(r);
    }

    private static final int N = 4;

    private static int[] students = {0, 1, 2, 3};
    private static Map<Integer, List<Integer>> pairs = new HashMap<>();

    static {
        pairs.put(0, Arrays.asList(1, 2, 3));
        pairs.put(1, Arrays.asList(0, 2, 3));
        pairs.put(2, Arrays.asList(0, 1, 3));
        pairs.put(3, Arrays.asList(0, 1, 2));
    }

    /**
     * taken[i] 의 i 번째 학생이 짝을 이미 찾았으면 true 아니면 false 를 리턴.
     * @param taken
     * @return
     */
    private int countPairings(boolean[] taken) {
        //중복을 피하기 위해 남은 학생들 중 가장 번호가 빠른 학생을 찾는다.
        int firstTaken = -1;
        for (int i=0; i<N; i++)
            if (!taken[i]) {
                firstTaken = i;
                break;
            }
        //모든 학생을 찾았으면 한가지 경우를 찾았으니 종료.
        if (firstTaken == -1) return 1;
        int r = 0;
        for (int i=firstTaken+1; i<N; i++) {
            if (!taken[i] && areFriends(i, firstTaken)) {
                taken[i] = taken[firstTaken] = true;
                r += countPairings(taken);
                taken[i] = taken[firstTaken] = false;
            }
        }
        return r;
    }

    private boolean areFriends(int i, int j) {
        if (i == j) return false;
        return pairs.get(i).contains(j) && pairs.get(j).contains(i);
    }
}
