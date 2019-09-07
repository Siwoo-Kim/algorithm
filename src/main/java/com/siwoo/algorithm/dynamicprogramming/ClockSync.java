package com.siwoo.algorithm.dynamicprogramming;

/**
 * 4 x 4 격자 형태로 16 개의 시계가 있을 때,
 * 각 시계들은 모두 3시, 6시, 9시 혹은 12시를 가리키고 있다.
 * 시계를 조작하는 10개의 스위치가 있고
 * 한 스위치를 누를 때마다 해당 스위치와 연결된 시계들의 시간이 3시간씩 앞으로 움직일 때,
 * 모든 시계를 12시로 돌리기 위해 최소한 스위츠를 몇 번이나 눌러야 할지 계산하라.
 *
 */
public class ClockSync {

    public static void main(String[] args) {
        ClockSync clockSync = new ClockSync();
        int cnt = clockSync.sync(0);
        System.out.println(cnt);
    }

    private static final int SWITCHES = 10;
    private static final int CLOCKS = 16;
    private static int[] CLOCK_16 = {12, 6, 6, 6, 6, 6, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
    private static String[] SWITCH = {
            "xxx.............",
            "...x...x.x.x....",
            "....x.....x...xx",
            "x...xxxx........",
            "......xxx.x.x...",
            "x.x...........xx",
            "...x..........xx",
            "....xx.x......xx",
            ".xxxxx..........",
            "...xxx...x...x.."
    };

    public boolean areAligned() {
        for (int i=0; i<CLOCKS; i++) {
            if (CLOCK_16[i] != 12)
                return false;
        }
        return true;
    }

    public void pushSwitch(int swtch) {
        for (int i=0; i<CLOCKS; i++) {
            if (SWITCH[swtch].charAt(i) == 'x') {
                CLOCK_16[i] += 3;
                if (CLOCK_16[i]==15)
                    CLOCK_16[i] = 3;
            }
        }
    }

    public int sync(int swtch) {
        if (swtch == SWITCHES)
            return areAligned() ? 0: 9999;
        int r = 9999;
        for (int i=0; i<4; i++) {
            r = Math.min(r, i + sync(swtch + 1));
            pushSwitch(swtch);
        }
        return r;
    }
}
