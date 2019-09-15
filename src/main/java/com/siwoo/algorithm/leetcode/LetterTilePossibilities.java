package com.siwoo.algorithm.leetcode;

import sun.dc.pr.PRError;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by sm123tt@gmail.com on 2019-09-14
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class LetterTilePossibilities {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(  solution.numTilePossibilities("AAB"));
    }

    static class Solution {
        int[] countArray = new int[26];
        int r = 0;

        int numTilePossibilities(String tiles) {
            for (char c: tiles.toCharArray())
                countArray[c - 'A']++;
            count(countArray);
            return r;
        }

        private void count(int[] countArray) {
            for (int i=0; i<26; i++) {
                if (countArray[i] != 0) {
                    countArray[i]--;
                    r++;
                    count(countArray);
                    countArray[i]++;
                }
            }
        }
    }
}
