package com.lullaby.graph.lc947;

import java.awt.image.ImageProducer;
import java.util.*;
import java.util.function.Function;

/*
        0 1 2 3 4 5 6 7
       0· ·
       1·   ·
       2  · ·
       3
       4
       5
       6
       7
 */


/**
 * BFS + 邻接矩阵
 */
//class Solution {
//    public int removeStones(int[][] stones) {
//        boolean[] mark = new boolean[stones.length];
//        int count = 0;
//        for (int i = 0; i < stones.length; i++) {
//            if (!mark[i]) {
//                count++;
//                mark[i] = true;
//                Deque<int[]> queue = new ArrayDeque<>();
//                queue.offer(stones[i]);
//                while(!queue.isEmpty()) {
//                    int[] u = queue.poll();
//                    for (int j = 0; j < stones.length; j++) {
//                        if (!mark[j] && (stones[j][0] == u[0] || stones[j][1] == u[1])) {
//                            queue.offer(stones[j]);
//                            mark[j] = true;
//                        }
//                    }
//                }
//            }
//        }
//
//        return stones.length - count;
//    }
//}


/**
 * BFS + 邻接表
 */
//class Solution {
//    public int removeStones(int[][] stones) {
//        List<List<int[]>> edges = new ArrayList<>();
//        for (int i = 0; i < stones.length; i++) {
//            edges.add(new ArrayList<>());
//        }
//        for (int i = 0; i < stones.length; i++) {
//            for (int j = i + 1; j < stones.length; j++) {
//                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
//                    int[] vertex1 = {i, stones[i][0], stones[i][1]};
//                    int[] vertex2 = {j, stones[j][0], stones[j][1]};
//                    edges.get(i).add(vertex2);
//                    edges.get(j).add(vertex1);
//                }
//            }
//        }
//        boolean[] mark = new boolean[stones.length];
//        int count = 0;
//        for (int i = 0; i < edges.size(); i++) {
//            if (!mark[i]) {
//                count++;
//                Deque<int[]> queue = new ArrayDeque<>();
//                int[] vertex = {i, stones[i][0], stones[i][1]};
//                queue.offer(vertex);
//                mark[i] = true;
//                while (!queue.isEmpty()) {
//                    int[] u = queue.poll();
//                    for (int[] info : edges.get(u[0])) {
//                        if (!mark[info[0]]) {
//                            queue.offer(info);
//                            mark[info[0]] = true;
//                        }
//                    }
//                }
//            }
//        }
//
//        return stones.length - count;
//    }
//}





/**
 * 哈希表 + BFS
 */
//class Solution {
//    public int removeStones(int[][] stones) {
//        boolean[] mark = new boolean[stones.length];
//        int count = 0;
//        Map<Integer, List<Integer>> rowToStone = new HashMap<>();
//        Map<Integer, List<Integer>> colToStone = new HashMap<>();
//        for (int i = 0; i < stones.length; i++) {
//            rowToStone.computeIfAbsent(stones[i][0], k -> new ArrayList<>()).add(i);
//            colToStone.computeIfAbsent(stones[i][1], k -> new ArrayList<>()).add(i);
//        }
//        for (int i = 0; i < mark.length; i++) {
//            if (!mark[i]) {
//                count++;
//                Deque<Integer> queue = new ArrayDeque<>();
//                queue.offer(i);
//                while (!queue.isEmpty()) {
//                    int vertex = queue.poll();
//                    int row = stones[vertex][0];
//                    int col = stones[vertex][1];
//                    for (int neighbor : rowToStone.get(row)) {
//                        if (!mark[neighbor]) {
//                            queue.offer(neighbor);
//                            mark[neighbor] = true;
//                        }
//                    }
//                    for (int neighbor : colToStone.get(col)) {
//                        if (!mark[neighbor]) {
//                            queue.offer(neighbor);
//                            mark[neighbor] = true;
//                        }
//                    }
//                }
//            }
//        }
//
//        return stones.length - count;
//    }
//}


/**
 * 并查集
 */
class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, Integer> parent = new HashMap<>();
        for (int[] info : stones) {
            union(info[0], info[1], parent);
        }

        int count = 0;
        for (int key : parent.keySet()) {
            if (find(key, parent) == key) {
                count++;
            }
        }

        return stones.length - count;
    }

    public Integer find(int v, Map<Integer, Integer> parent) {
        if (!parent.containsKey(v)) {
            parent.put(v, v);
            return v;
        }

        if (parent.get(v) != v) {
            parent.put(v, find(parent.get(v), parent));
        }

        return parent.get(v);
    }

    public void union (int row, int col, Map<Integer, Integer> parent) {
        int rowParent = find(row, parent);
        int colParent = find(col + 10005, parent);
        if (rowParent != colParent) {
            parent.put(colParent, rowParent);
        }
    }
}