package com.siwoo.algorithm.dynamicprogramming;

/**
 * 재귀 호출.
 *  :재귀 함수란 자신이 수행할 작업을 유사한 형태의
 *  여러 조각으로 쪼갠 뒤 그 중 한 조각을 수행하고,
 *  나머지를 자기 자신을 호출해 실행하는 함수.
 *
 *  기저 사례
 *      :재귀 호출에서 쪼개지지 않은 가장 작은 작업
 *
 */
public class Sum {

    public static void main(String[] args) {
        Sum sum = new Sum();
        System.out.println(sum.recursiveSum(5));
    }

    //Invariant: n >= 1
    public int recursiveSum(int n) {
        if (n == 1) return 1;
        int e = recursiveSum(n - 1);
        int r = e + n;
        return r;
    }
}
