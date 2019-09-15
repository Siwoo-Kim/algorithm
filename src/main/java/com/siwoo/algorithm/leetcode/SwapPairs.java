package com.siwoo.algorithm.leetcode;


import com.siwoo.algorithm.datastructure.LinkedList;

import java.util.Optional;

public class SwapPairs {

    static class Solution {
        public static void main(String[] args) {
            ListNode listNode = new ListNode(1);
            listNode.next = new ListNode(2);
            listNode.next.next = new ListNode(3);
            listNode.next.next.next = new ListNode(4);
            Solution solution = new Solution();
            ListNode node = solution.swapPairs(listNode);

        }
        public ListNode swapPairs(ListNode head) {
            if (head == null) return head;
            ListNode nextNode = head.next;
            head.next = head.next.next;
            nextNode.next = head;
            nextNode.next.next = swapPairs(head.next);
            return nextNode;
        }
    }
}



class ListNode {
 int val;
 ListNode next;
 ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
