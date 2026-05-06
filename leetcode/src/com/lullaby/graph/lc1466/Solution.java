package com.lullaby.graph.lc1466;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<int[]>> edges = new ArrayList<>();

    boolean[] mark;

    int count;

    public int minReorder(int n, int[][] connections) {
        mark = new boolean[n];
        for (int i  = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : connections) {
            int u = info[0];
            int v = info[1];
            edges.get(u).add(new int[] {v, 1});
            edges.get(v).add(new int[] {u, 0});
        }

        dfs(0);

        return count;
    }

    public void dfs(int u) {
        mark[u] = true;
        for (int[] vertex : edges.get(u)) {
            if (!mark[vertex[0]]) {
                if (vertex[1] == 1) {
                    count++;
                }
                dfs(vertex[0]);
            }
        }
    }
}