package com.siwoo.algorithm.dynamicprogramming;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 여행하는 외판원 TSP
 *  한 영원 사원이 한 도시에서 출발해 다른 도시들을 전부 한 번씩
 *  방문한 뒤 시작 도시로 돌아오려 할때 가장 짧은 거리를 구하려라.
 *
 *  이때 각 도시들은 모두 직선 도로 연결되어 있으며 각 도로가 주어진다.
 */
public class TSP {

    public static void main(String[] args) {
        TSP tsp = new TSP();
        LinkedList<Integer> path = new LinkedList<>();;
        path.push(0);
        int dist = tsp.shortestPath(path, new boolean[4], 0);
        System.out.println(dist);
    }
    final static int N = 4;
    final static Integer DIST[][] = {
            {0, 3, 4, 5},
            {2, 0, 2, 2},
            {4, 2, 0, 5},
            {6, 2, 4, 0},
    };


    /**
     * path 가 지금까지 만든 경로일 때,
     * 나머지 도시들 모두 방문하는 경로들 중
     * 가장 짧은 거리를 반환한다.
     *
     * @param path 지금까지 만든 경로
     * @param visited 각 도시의 방문 여부
     * @param cLength 지금까지 만든 경로의 길이
     * @return
     */
    int shortestPath(Deque<Integer> path, boolean[] visited, int cLength) {
        if (path.size() == N)
            return DIST[path.peekFirst()][path.peekLast()];
        int r = Integer.MAX_VALUE;
        for (int next=0; next<4; next++) {
            if (visited[next]) continue;
            int here = path.peekLast();
            path.addLast(next);
            visited[next] = true;
            int c = shortestPath(path, visited, cLength + DIST[here][next]);
            r = Math.min(r, c);
            visited[next] = false;
            path.pollLast();
        }
        return r;
    }
}
