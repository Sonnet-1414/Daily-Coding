package com.lullaby.graph.lc841;

import java.util.List;

/**
 * DFS
 * O(n + m)
 */
class Solution {

    boolean[] mark;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        mark = new boolean[rooms.size()];
        mark[0] = true;
        dfs(0, rooms);
        for (boolean flag : mark) {
            if (!flag) return flag;
        }

        return true;
    }

    public void dfs(int u, List<List<Integer>> rooms) {
        mark[u] = true;
        for (int vertex : rooms.get(u)) {
            if (!mark[vertex]) {
                dfs(vertex, rooms);
            }
        }
    }
}