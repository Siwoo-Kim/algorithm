package com.siwoo.algorithm.leetcode;

/**
 * Created by sm123tt@gmail.com on 2019-09-14
 * Project : algorithm
 * Github : http://github.com/Siwoo-Kim
 */

public class StripOffParentheses {

    public static void main(String[] args) {
        StripOffParentheses stripOffParentheses = new StripOffParentheses();
        System.out.println(stripOffParentheses.removeOuterParentheses("(()())(())(()(()))"));
    }

    public String removeOuterParentheses(String s) {
        int anchor = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                anchor++;
                if (anchor != 1) {
                    sb.append(c);
                }
            } else {
                anchor--;
                if (anchor != 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

}
