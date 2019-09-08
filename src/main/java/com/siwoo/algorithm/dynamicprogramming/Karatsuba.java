package com.siwoo.algorithm.dynamicprogramming;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 카르츠바의 곱셈을 분할 정복으로 구현하라.
 */

public class Karatsuba {

    public static void main(String[] args) {
        Karatsuba karatsuba = new Karatsuba();
        List<Integer> r = karatsuba.multiply(Arrays.asList(4, 3, 2, 1), Arrays.asList(8, 7, 6, 5));

    }

    //a 와 b 를 자리수를 기준으로 나눈다.
    //만약 a1,b1 이 256 자리수라면  a1, b1 은 첫 128자리, a0, b0 은 그 다음 128 자리수를 저장.

    //a = a1 x 10^128 + a0
    //b = b1 x 10^128 + b0
    //a x b = (a1 x 10^128 + a0) * (b1 x 10^128 + b)
    //= a1 x b1 x 100^256 + (a1 x b0 + a0 x b1) x 10^128 + a0 x b0

    private List<Integer> add(List<Integer> a, List<Integer> b, int k) {
        a = ensureSize(a, Math.max(a.size(), b.size() + k));
        for (int i=0; i<b.size(); i++)
            a.set(i + k, a.get(i + k) + b.get(i));
        return normalize(a);
    }

    private List<Integer> sub(List<Integer> a, List<Integer> b) {
        a = ensureSize(a, Math.max(a.size(), b.size() + 1));
        for (int i=0; i<b.size(); i++)
            a.set(i, a.get(i) - b.get(i));
        return normalize(a);
    }

    List<Integer> karatsuba(List<Integer> a, List<Integer> b) {
        int an = a.size(), bn = b.size();
        if (an < bn) return karatsuba(b, a);
        if (an == 0 || bn == 0) return new ArrayList<>();
        if (an <= 50) return multiply(a, b);
        int half = an / 2;
        List<Integer> a0 = new ArrayList<>(a.subList(0, half));
        List<Integer> a1 = new ArrayList<>(a.subList(half, a.size()));
        List<Integer> b0 = new ArrayList<>(b.subList(0, Math.min(b.size(), half)));
        List<Integer> b1 = new ArrayList<>(b.subList(Math.min(b.size(), half), b.size()));

        List<Integer> z2 = karatsuba(a1, b1);
        List<Integer> z0 = karatsuba(a0, b0);

        z0 = add(a0, a1, 0);
        z0 = add(b0, b1, 0);
        List<Integer> z1 = karatsuba(a0, b0);
        z1 = sub(z1, z0);
        z1 = sub(z1, z2);

        List<Integer> r = new ArrayList<>();
        r = add(r, z0, 0);
        r = add(r, z1, half);
        r = add(r, z2, half * 2);
        return r;
    }

    private List<Integer> ensureSize(List<Integer> a, int size) {
        ((ArrayList )a).ensureCapacity(size);
        while (a.size() < size)
            a.add(0);
        return a;
    }

    private List<Integer> multiply(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList<>();
        for (int i=0,N=a.size()+b.size()+1; i<N; i++) c.add(0);

        for (int i=0; i<a.size(); i++)
            for (int j=0; j<b.size(); j++)
                c.set(i+j, c.get(i+j) + (a.get(i) * b.get(j)));
        return normalize(c);
    }

    private List<Integer> normalize(List<Integer> c) {
        c.add(0);
        for (int i=0,N=c.size(); i<N-1; i++) {
            int v = c.get(i);
            int carry = v / 10;
            c.set(i, v % 10);
            c.set(i+1, c.get(i+1) + carry);
        }
        while (c.size() > 1 && c.get(c.size()-1) == 0)
            c.remove(c.size()-1);
        return c;
    }


}
