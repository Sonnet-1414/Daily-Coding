package com.lullaby.graph.lc1042;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> edges = new ArrayList<>();

    int[] mark;

    int count = 0;

    public int[] gardenNoAdj(int n, int[][] paths) {
        mark = new int[n];
        edges.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : paths) {
            edges.get(info[0]).add(info[1]);
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (mark[i - 1] == 0) {
                dfs(i);
            }
        }
        return mark;
    }

    public void dfs(int u) {

        if (count >=  mark.length) {
            return;
        }

        for (int i = 1; i <= 4; i++) {
            mark[u - 1] = i;
            boolean flag = false;
            for (int vertex : edges.get(u)) {
                if (mark[vertex - 1] == i) {
                    flag = true;
                }
            }
            if (flag) continue;
            count++;
            for (int vertex : edges.get(u)) {
                if (count >= mark.length) return;
                if (mark[vertex - 1] == 0) {
                    dfs(vertex);
                }
            }
            return;
        }
    }
}