package com.siwoo.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * 분할 정복을 통해 퀵소트를 구현하라.
 *
 * 1. 기준 수를 구하여 왼쪽에 기준 수보다 작은 수들, 오른쪽에 그준 수보다 큰 수들로 정렬한다.
 * 2. 왼쪽의 수들과 오른쪽 수들을 작은 문제로 나눈다. (Divide)
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, 54, 3, 3, 2, -4, 5, 9, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a, 0, a.length);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] a, int low, int high) {
        if (high - low < 2)
            return;
        int pivot = partition(a, low, high);
        sort(a, low, pivot);
        sort(a, pivot+1, high);
    }

    private int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while (low < high) {
            while (low < high && pivot <= a[--high]) ;
            if (low < high)
                a[low] = a[high];
            while (low < high && pivot >= a[++low]) ;
            if (low < high)
                a[high] = a[low];
        }
        a[high] = pivot;
        return high;
    }
}
