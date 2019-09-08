package com.siwoo.algorithm.leetcode;


public class KthLargestElement {

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] a = {32, 1, 4, 98, 33, -1, 54, 5, 2, 9, 2, 13};

        int r = kthLargestElement.findKthLargest(a, 2);
        System.out.println(r);
    }

    private int findKthLargest(int[] a, int k) {
        merge(a, 0, a.length);
        return a[a.length - k];
    }

    private void merge(int[] a, int low, int high) {
        if (high - low < 2)
            return;
        int pivot = partition(a, low, high);
        merge(a, low, pivot);
        merge(a, pivot+1, high);
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
