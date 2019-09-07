package com.siwoo.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * 시간 복잡도 분석 연습.
 *      : O 표기법은 함수에서 가장 빨리 증가하는 항만을 남긴 채 나머지를 다 버리는 표기법.
 *      : N 에 대한 함수 f(N)이 주어질 때, f(N)=O(g(N)) 이라 쓰는 것은
 *      아주 큰 N0 와 C(N0, C>0) 을 적절히 선택하면, N0<=N 인 모든 N 에 대해
 *      f(N)<=C x g(N) 은 항상 참이 될 수 있다.
 *
 * 프로그래밍 대회의 시간 내 문제풀기.
 *  : 입력의 크기를 시간 복잡도에 대입해서 얻은 반복문 수행 횟수에 대해
 *  1초당 반복문 수행 횟수가 1억(10^8) 을 넘어가면 시간 제한을 초과할 가능성이 있다.
 *  즉, O(N^3) 에 10000을 대입하면 1억을 초과.
 *
 *  O(N^3) 알고리즘. 2650인 입력까지 1 초 내외
 *  O(N^2) 알고리즘. 40960인 입력까지 1 초 내외
 *  O(NlgN) 알고리즘. 2천만인 입력까지 1 초 내외
 *  O(N) 알고리즘.  1억 6천만인 입력까지 1초 내외
 *  
 *
 */
public class Sort {

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] a = {4, 1, 3, 6, 5 ,7};
        sort.insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 모든 i에 대해 A[i..N-1] 에서 가장 작은 원소를 찾은 뒤, 이것을 A[i] 을 넣는다.
     * N-1 E(시그마) i=1 = 1/2 * N^2 -> O(N^2)
     * @param a
     */
    void selectionSort(int[] a) {
        final int N = a.length;
        for (int i=0; i<N; i++) {
            //A[0..i-1] 에 최소 값을 i 와 바꾼다.
            int min = i;
            for (int j=i+1; j<N; j++) {
                if (a[i] > a[j])
                    min = j;
            }
            swap(a, min, i);
        }
    }

    void insertionSort(int[] a) {
        final int N = a.length;
        for (int i=1; i<N; i++) {
            int e = a[i];
            int j=i;
            while (j>0 && a[j-1]>e) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = e;
        }
    }

    private void swap(int[] a, int e1, int e2) {
        int t = a[e1];
        a[e1] = a[e2];
        a[e2] = t;
    }
}
