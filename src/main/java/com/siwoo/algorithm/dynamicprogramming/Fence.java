package com.siwoo.algorithm.dynamicprogramming;

/**
 * Fence 울타리 잘라내기
 * 너비가 같은 N개의 나무 판자를 붙인 울타리가 있을 때,
 * 울타리의 일부를 직사각형으로 잘라내 재활용 하려 한다.
 * 이때 울타리를 구성하는 각 판자의 높이가 주어질 때,
 * 잘라낼 수 있는 직사각형의 최대 크기를 계산하라.
 *
 */
public class Fence {

    public static void main(String[] args) {
        Fence fence = new Fence();
        int r = fence.bruteForce();
        System.out.println(r);
        r = fence.solve(0, 6);
        System.out.println(r);
    }

    private static final int[] HEIGHT = {7, 1, 5, 9, 6, 7, 3};

    /**
     * h[left..right] 구간에서 가장 큰 사각형의 넓이를 반환한다.
     *
     * @param left
     * @param right
     * @return
     */
    private int solve(int left, int right) {
        if (left == right) return HEIGHT[left];
        int mid = (right + left) / 2;
        int r = Math.max(solve(left, mid), solve(mid+1, right));
        int i=mid, j=mid+1;
        int height = Math.min(HEIGHT[i], HEIGHT[j]);
        r = Integer.max(r, height * 2);
        while (i > left || j < right) {
            if (j < right && (i == left || HEIGHT[i-1] < HEIGHT[j+1])) {
                j++;
                height = Math.min(height, HEIGHT[j]);
            } else {
                i--;
                height = Math.min(height, HEIGHT[i]);
            }
            r = Math.max(r, (j - i + 1) * height);
        }
        return r;
    }

    //(RIGHT - LEFT + 1) * minHeight(HEIGHT[RIGHT], HEIGHT[LEFT])

    private int bruteForce() {
        int r = 0, N = HEIGHT.length;
        for (int left=0; left<N; left++) {
            int minHeight = HEIGHT[left];
            for (int right=left; right<N; right++) {
                minHeight = Math.min(minHeight, HEIGHT[right]);
                r = Math.max(r, minHeight * (right - left + 1));
            }
        }
        return r;
    }

}
