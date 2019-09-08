package com.siwoo.algorithm.dynamicprogramming;


import java.text.StringCharacterIterator;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * 검은 색과 흰 색밖에 없는 흑백 그림의 쿼드 트리가 주어지며
 * 이때 흰색은 w, 검은색은 b, 모든 픽셀이 같은 색이 아니라면 x 이라 한다.
 * 쿼드 트리로 압축된 흑백 그림이 주어질 때, 상하로 뒤집은 그림을 쿼드 트리 압축해서 출력하라.
 *
 */
public class QuardTree {

    char[][] DECOMPRESSED = new char[16][16];
    int pointer = 0;

    public static void main(String[] args) {
        QuardTree quardTree = new QuardTree();
        quardTree.decompressed("xxwwwbxwxwbbbwwxxxwwbbbwwwwbb", 0, 0, 16);
        quardTree.pointer = 0;
        System.out.println(quardTree.reverse("xxwwwbxwxwbbbwwxxxwwbbbwwwwbb"));
    }

    private String reverse(String s) {
        char head = s.charAt(pointer++);
        if (head == 'b' || head == 'w') {
          return head + "";
        } else {
            String tl = reverse(s);
            String tr = reverse(s);
            String bl = reverse(s);
            String br = reverse(s);
            return "x" + bl + br + tl + tr;
        }
    }

    private void decompressed(String s, int y, int x, int size) {
        char head = s.charAt(pointer++);
        if (head == 'b' || head == 'w')
            for (int dy=0; dy<size; dy++)
                for (int dx=0; dx<size; dx++)
                    DECOMPRESSED[dy][dx] = head;
        else {
            int half = size / 2;
            decompressed(s, y, x, half);
            decompressed(s, y, x+half, half);
            decompressed(s, y+half, x, half);
            decompressed(s, y+half, x+half, half);
        }
    }


}
