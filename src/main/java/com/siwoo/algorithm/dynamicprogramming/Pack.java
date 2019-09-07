package com.siwoo.algorithm.dynamicprogramming;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.List;

/**
 * 여행을 가기위해 짐을 싸려 한다.
 * 비행기 규정상 캐리어를 하나만 가지고 갈 수 있는데,
 * 모든 물건들이 다 캐리어 안에 들어가지 않는다.
 * 이때 각 물건들의 절박도 need 와 부피 volume 가 주어질 때,
 * 캐리어의 용량 w 이하에 절박도를 최대화하는 목록을 계산하라.
 */
public class Pack {

    private final int C;
    private final int N; //가져갈 물건의 수
    private int need[];     // 각 물건의 절박도
    private int volume[]; //각 물건의 부피
    private String name[];

    public Pack(int capacity, int n, int[] need, int[] volume, String[] name) {
        C = capacity;
        N = n;
        this.need = need;
        this.volume = volume;
        this.name = name;
    }

    /**
     * 캐리어에 남은 용량이 capacity 일 때, item 이후의 물건을
     * 담아 얻을 수 있는 최대 절박도의 합을 반환.
     * @param capacity
     * @param item
     * @return total needs
     */
    private int pack(int capacity, int item) {
        //가져갈 물건이 없을 때
        if (item == N) return 0;
        //물건을 가져가지 않을 때
        int r = pack(capacity, item+1);
        //물건을 가져갈 때
        if (capacity >= volume[item])
            r = Integer.max(r,pack(capacity - volume[item], item+1) + need[item]);
        return r;
    }

    /**
     * {@link Pack#pack()} 이 선택한 물건들의 목록을 picked 에 저장한다.
     * @param capacity
     * @param item
     * @param picked
     */
    void reconstruct(int capacity, int item, List<String> picked) {
        //BASE CASE 모든 물건을 다 고려했음.
        if (item == N) return;
        if (pack(capacity, item) == pack(capacity, item + 1)) {
            reconstruct(capacity, item+1, picked);
        } else {
            picked.add(name[item]);
            reconstruct(capacity-volume[item], item+1, picked);
        }

    }

    public List<String> pack() {
        List<String> list = new ArrayList<>();
        reconstruct(C,  0, list);
        return list;
    }

    public static void main(String[] args) {
        int[] volumn = {4, 2, 6, 4, 2, 10};
        int[] need ={7, 10, 6, 7, 5, 4};
        String[] name = {"Computer", "Camera", "XBOX360", "Coffee Grinder", "Dumbell", "Encyclopedia"};
        Pack pack = new Pack(10, 6, need, volumn, name);
        System.out.println(pack.pack());
    }

}
