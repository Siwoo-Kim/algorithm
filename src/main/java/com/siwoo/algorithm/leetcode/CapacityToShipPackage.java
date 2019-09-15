package com.siwoo.algorithm.leetcode;


import java.util.stream.IntStream;

/**
 * 주어진 경과 시간 D 와 각 패키지의 무게 W[i] 가 주어질 때,
 * D 일까지 운송을 완료하기 위해 하루 최소 수용량을 계산하라.
 */
public class CapacityToShipPackage {

    static class Solution {
        static int[] W = {1,2,3,4,5,6,7,8,9,10};
        static int D = 3;

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.canShip(W, 5, 15));

        }

        public int shipWithinDays(int[] weights, int D) {
            int low=0, high= IntStream.of(weights).sum();
            while (low < high) {
                int mid = (low + high) / 2;
                if (canShip(weights, D, mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        private boolean canShip(int[] weights, int d, int c) {
            int day = 0, load = c;
            for (int w=0; w<weights.length; w++) {
                if (weights[w] > c) return false;
                load += weights[w];
                if (load > c) {
                    load = w;
                    day++;
                }
                if (day > d)
                    return false;
            }
            return true;
        }
    }
}
