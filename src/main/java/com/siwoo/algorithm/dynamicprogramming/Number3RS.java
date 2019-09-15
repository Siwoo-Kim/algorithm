package com.siwoo.algorithm.dynamicprogramming;

import java.util.BitSet;

/**
 * Created by sm123tt@gmail.com on 2019-09-14
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class Number3RS {

    public static void main(String[] args) {
        int fullPizza = (1 << 20) - 1;
        int zeroPizza = 0;
//        for (int i=0; i<20; i++)
//            System.out.println(isBitSet(zeroPizza, 0));
//
//        for (int i=0; i<20; i++)
//            System.out.println(isBitSet(fullPizza, 0));

        int sets = 0;
        int one = 0, two = 1, ten = 9;
        sets |= 1 << one;
        sets |= 1 << two;
        sets |= 1 << ten;

//        sets &= ~(1 << ten);
//        for (int i=0; i<20; i++)
//            System.out.println(isBitSet(sets, i));

        //sets ^= 1 << ten;

        int sets2 = 0;
        int three = 3, four = 4, five = 5;

        sets2 |= 1 << one;
        sets2 |= 1 << three;
        sets2 |= 1 << four;
        sets2 |= 1 << five;

        int allSets = sets | sets2;
        allSets = sets & sets2;
//        for (int i=0; i<20; i++)
//            System.out.println(isBitSet(allSets, i));

        allSets = sets & ~sets2;

        System.out.println(bitCount(allSets));
        System.out.println(Integer.numberOfTrailingZeros(allSets));

        for (int i=0; i<20; i++)
            System.out.println(isBitSet(allSets, i));

        int firstToppings = (allSets & -allSets);
        System.out.println(firstToppings);

        printSubsets(allSets);
    }

    private static void printSubsets(int sets) {
        for (int subset=sets; subset != 0 ; subset = ((subset-1) & sets)) {
            for (int bit=0;bit<20; bit++)
                if ((subset & (1 << bit)) > 1)
                    System.out.print(bit + ",");
            System.out.println();
        }
    }

    public static int bitCount(int x) {
        if (x == 0) return 0;
        return x % 2 + bitCount(x/2);
    }
    public static boolean isBitSet(long a, int bit) {
        return (a & (1 << bit)) > 0;
    }
}
