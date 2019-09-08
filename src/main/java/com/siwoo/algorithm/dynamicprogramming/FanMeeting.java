package com.siwoo.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * 팬미팅에 참가한 M명의 팬들이 줄 서서
 * N 명의 팀과 오른쪽 멤버에서 시작해 한 명씩 왼쪽으로
 * 움직이며 멤버들과 한번씩 포옹을 하려 한다.
 * 이때 남성 멤버와 남성 팬은 포옹대신 악수를 할 때,
 * 주어진 멤버들과 팬들의 성별에서 팬미팅이 진행되는 동안
 * 멤버가 동시에 포옹을 몇 번을 하는지 계산하라.
 *
 */

public class FanMeeting {

    private static String MEMBERS = "MFMFMFFFMMMFMF";
    private static String FANS = "MMFFFFMFFFMFFFFFFMFFFMFFFFMFMMFFFFFFF";

    public static void main(String[] args) {
        FanMeeting fanMeeting = new FanMeeting();
        fanMeeting.hugs();


    }

    public int hugs() {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for (int i=0; i<MEMBERS.length(); i++) A.add(MEMBERS.charAt(i) == 'M' ? 1 : 0);
        for (int i=0; i<FANS.length(); i++) B.add( FANS.charAt(i) == 'M' ? 1 : 0);
        List<Integer> C = multiply(A, B);
        int allHugs = 0;
        for (int i=MEMBERS.length()-1; i<FANS.length(); i++) {
            if (C.get(i) == 0)
                allHugs++;
        }
        return allHugs;

    }

    List<Integer> multiply(List<Integer> A, List<Integer> B) {
        int N = A.size()+B.size()+1;
        List<Integer> c = new ArrayList<>();
        for (int i=0; i<N; i++) c.add(0);
        for (int i=0,NI=A.size(); i<NI; i++)
            for (int j=0,NJ=B.size(); j<NJ; j++) {
                c.set(i+j, c.get(i + j) + A.get(i) * B.get(j));
            }
        return nomarlize(c);
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
