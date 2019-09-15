package com.siwoo.algorithm.datastructure;


import com.siwoo.algorithm.dynamicprogramming.Lis;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    private ListNode head;
    private List<ListNode> deleted = new ArrayList<>();

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.delete(2);
        list.recover(2);

    }

    public void recover(Object o) {
        ListNode n = deleted.stream().filter(d -> d.el == o).findFirst().orElse(null);
        if (n != null) {
            n.prev.next = n;
            n.next.prev = n;
        }
    }
    public void delete(Object o) {
        ListNode n =  findNode(o);
        n.prev.next = n.next;
        n.next.prev = n.prev;
        deleted.add(n);
    }

    private ListNode findNode(Object o) {
        ListNode n = head;
        while (n != null && !n.el.equals(o)) {
            n = head.next;
        }
        return n;
    }

    public void add(Object o) {
        if (head == null)
            head = new ListNode(o, null, null);
        else {
            ListNode newHead = new ListNode(o, null, head);
            head.prev = newHead;
            head = newHead;
        }
    }

    private static class ListNode {
        Object el;
        ListNode prev;
        ListNode next;

        public ListNode(Object el, ListNode prev, ListNode next) {
            this.el = el;
            this.prev = prev;
            this.next = next;
        }
    }
}
