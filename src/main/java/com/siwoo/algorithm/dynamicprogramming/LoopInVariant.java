package com.siwoo.algorithm.dynamicprogramming;

import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.List;

/**
 * 반복문 불변식(수학적 귀납법).
 *
 * 수학적 귀납법.
 *  :앞에서 일어난 결과가 뒤에서도 일어날 것이라는 것을 증명하는 방법.
 *
 *  1. 단계 나누기.
 *  2. 첫 단계 증명.
 *  3. 귀납 증명.
 *
 *  반복문 불변식.
 *      :반복문의 내용이 한 번 실행될 때마다
 *      중간 결과가 답으로 가는 길 위에 잘 있는지를 명시하는 조건.
 *
 *  1. 반복문 진입시에 불변식이 성립한다.
 *  2. 반복문 내용이 불변식을 깨드리지 않음을 성립한다.
 *  3. 반복문 종료시에 불변식이 성립하면 답이 구했음이 성립한다.
 *
 */
public class LoopInVariant {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(01, 2, 3, 4, 7, 10, 15);
        LoopInVariant loopInVariant = new LoopInVariant();
        int i = loopInVariant.binarySearch(a, 10);
    }

    /**
     * invariant: a 는 오름 차순으로 정렬되어 있다.
     * @param a
     * @param x
     * @return a[i-1] < x <= a[i] 인 i 를 리턴.
     */
    private int binarySearch(List<Integer> a, int x) {
        int N = a.size(), high = N, low = -1;
        //Loop-invariant: a[low] < a[high]
        //Loop-invariant: a[low] < x <= a[high]
        while (low+1 < high) {
            int mid = (low + high) / 2;
            if (x <= a.get(mid))
                high = mid;
            else
                low = mid;
        }
        return high;
    }

}
