package com.siwoo.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReserveLinkedList {


    static class Solution {
        public static void main(String[] args) {
            ListNode node = new ListNode(1);
            node.next = new ListNode(2);
            node.next.next = new ListNode(3);
            node.next.next.next = new ListNode(4);
            Solution solution = new Solution();
            ListNode node1 = solution.reverseList(node, null);
        }

        public ListNode reverseList(ListNode c, ListNode prev) {
            if (c == null) return prev;
            ListNode next = c.next;
            prev = c;
            c = next;
            c.next = reverseList(c, prev);
            return prev;
        }
    }
}
