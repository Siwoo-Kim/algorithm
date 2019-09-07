package com.siwoo.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sm123tt@gmail.com on 2019-09-07
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class Karatsuba {

    public static void main(String[] args) {
        Karatsuba karatsuba = new Karatsuba();
        System.out.println(karatsuba.multiply("123", "456"));
    }

    String multiply(String A, String B) {
        int N = A.length()+B.length()+1;
        A = new StringBuilder().append(A).reverse().toString();
        B = new StringBuilder().append(B).reverse().toString();
        List<Integer> c = new ArrayList<>();
        for (int i=0; i<N; i++) c.add(0);
        for (int i=0,NI=A.length(); i<NI; i++)
            for (int j=0,NJ=B.length(); j<NJ; j++) {
                c.set(i+j, c.get(i + j) + (Character.getNumericValue(A.charAt(i)) * Character.getNumericValue(B.charAt(j))));
            }
        String r = nomarlize(c).stream()
                .map(i -> i + "")
                .collect(Collectors.joining());
        return new StringBuilder().append(r).reverse().toString();
    }

    private List<Integer> nomarlize(List<Integer> c) {
        c.add(0);
        for (int i=0,N=c.size(); i+1<N; i++) {
            int v = c.get(i);
            int carry = v / 10;
            int remainder = v % 10;
            c.set(i + 1,  c.get(i + 1) + carry);
            c.set(i, remainder);
        }
        while (c.size() > 1 && c.get(c.size() - 1) == 0)
            c.remove(c.size()-1);
        return c;
    }
}
