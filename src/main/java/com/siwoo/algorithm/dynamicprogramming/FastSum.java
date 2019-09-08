package com.siwoo.algorithm.dynamicprogramming;

/**
 * 분할 정복.
 * Divide: 문제를 더 작은 문제로 분할하는 과정
 * Merge: 각 서브 문제에 대해 구한 답을 원래 문제에 대한 답으로 병합.
 * Base case: 답을 분할할 수 없는 매우 작은 문제.
 */
public class FastSum {

    public static void main(String[] args) {
        FastSum fastSum = new FastSum();
        int r = fastSum.fastSum(10);
        System.out.println(r);
    }

    //fastSum = (1+2+3...n/2) + ( (n/2+1) + (n/2+2) ... + n)
    //(n/2+1) + (n/2+2) ... +n
    // = n/2 * n/2 + (1+2+3...n/2)
    // = (n/2)^2 + fastSum(n/2)
    // fastSum = 2 x fastSum(n/2) + (n/2)^2 (n % 2 == 0)

    //fastSum(1010) = fastSum(101) * 2 + 25
    //fastSum(101) = fastSum(100) + 5
    //fastSum(100) = fastSum(10) * 2 + 4
    //fastSum(10) = fastSum(10) * 2 + 1
    //fastSum(1) = 1
    int fastSum(int n) {
        if (n == 1) return 1;
        if (n % 2 == 1) return fastSum(n-1) + n;
        return 2 * fastSum(n/2) + (n/2) * (n/2);
    }

}
