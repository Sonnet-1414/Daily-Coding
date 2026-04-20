package com.lullaby.graph.lc797;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(0, graph);

        return res;
    }

    public void dfs(int u, int[][] graph) {
        if (u == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
        }
        // 需要注意的是，push和pop会在stack的头部操作，因此会导致逆序
        for (int vertex : graph[u]) {
            path.offerLast(vertex);
            dfs(vertex, graph);
            path.pollLast();
        }
    }
}
