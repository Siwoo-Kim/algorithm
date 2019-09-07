package com.siwoo.algorithm.leetcode;

import java.util.Stack;

public class DefangingAnIpAddress {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.defangIPaddr("255.100.50.1"));
        System.out.println(solution.defangIPaddr("255.100.50.0"));
        System.out.println(solution.defangIPaddr("1.1.1.1"));
    }

    static class Solution {
//        public String defangIPaddr(String address) {
//            StringBuilder sb = new StringBuilder();
//            for (int i=0; i<address.length(); i++) {
//                char c = address.charAt(i);
//                if (c == '.') {
//                    sb.append(address.substring(0, i));
//                    sb.append("[.]");
//                    address = address.substring(i+1);
//                    i = 0;
//                }
//            }
//            return sb.append(address).toString();
//        }

        public String defangIPaddr(String address) {
            if (address.isEmpty()) return address;
            String el = "";
            for (int i=0; i<address.length(); i++) {
                char c = address.charAt(i);
                if (c == '.')
                    return address.substring(0, i) + "[.]" + defangIPaddr(address.substring(i+1));
                if (i == address.length() - 1)
                    el = address;
            }
            return el;
        }
    }
}
