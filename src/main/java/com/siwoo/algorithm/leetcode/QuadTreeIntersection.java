package com.siwoo.algorithm.leetcode;


public class QuadTreeIntersection {

    static class Solution {
        public Node intersect(Node t1, Node t2) {
            if (t1.isLeaf) return t1.val ? t1: t2;
            if (t2.isLeaf) return t2.val ? t2: t1;

            Node tl = intersect(t1.topLeft, t2.topLeft);
            Node tr = intersect(t1.topRight, t2.topRight);
            Node bl = intersect(t1.bottomLeft, t2.bottomLeft);
            Node br = intersect(t1.bottomRight, t2.bottomRight);

            if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf &&
                    (tl.val && tr.val && bl.val && br.val || !t1.val && !tr.val && !bl.val && !br.val)) {
                return new Node(tl.val, true, null, null, null, null);
            } else {
                return new Node(false, false, tl, tr, bl, br);
            }
        }
    }
}

