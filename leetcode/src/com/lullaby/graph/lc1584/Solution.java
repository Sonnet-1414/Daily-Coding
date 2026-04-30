package com.lullaby.graph.lc1584;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * kruskal + 集合
 */
//class Solution {
//    public int minCostConnectPoints(int[][] points) {
//
//        if (points.length == 1) return 0;
//
//        int[] parent = new int[points.length];
//        List<List<Integer>> edges = new ArrayList<>();
//        for (int i = 0; i < points.length; i++) {
//            parent[i] = i;
//            for (int j = i + 1; j < points.length; j++) {
//                int distance = getDistance(points[i], points[j]);
//                List<Integer> edge = new ArrayList<>(List.of(i, distance, j));
//                edges.add(edge);
//            }
//        }
//
//        edges.sort((o1, o2) -> o1.get(1) - o2.get(1));
//
//        int sum = 0;
//        for (int i = 0, count = 0; i < edges.size() && count < points.length - 1; i++) {
//            List<Integer> edge = edges.get(i);
//            if (find(edge.get(0), parent) == find(edge.get(2), parent)) continue;
//            sum += edge.get(1);
//            union(edge.get(0), edge.get(2), parent);
//            count++;
//        }
//        return sum;
//    }
//
//    public int getDistance(int[] point1, int[] point2) {
//        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
//    }
//
//    public int find(int value, int[] parent) {
//        if (parent[value] != value) {
//            parent[value] = find(parent[value], parent);
//        }
//        return parent[value];
//    }
//
//    public void union(int a, int b, int[] parent) {
//        int rootA = find(a, parent);
//        int rootB = find(b, parent);
//        if (rootB == rootA) return;
//        parent[rootA] = rootB;
//    }
//}


/**
 * kruskal + 数组
 */
//class Solution {
//    public int minCostConnectPoints(int[][] points) {
//
//        if (points.length == 1) return 0;
//
//        int[] parent = new int[points.length];
//        int n = points.length;
//        int[][] edges = new int[n * (n - 1) / 2][3];
//        int index = 0;
//        for (int i = 0; i < points.length; i++) {
//            parent[i] = i;
//            for (int j = i + 1; j < points.length; j++) {
//                int distance = getDistance(points[i], points[j]);
//                edges[index][0] = i;
//                edges[index][1] = distance;
//                edges[index][2] = j;
//                index++;
//            }
//        }
//
//        Arrays.sort(edges, (o1, o2) -> o1[1] - o2[1]);
//
//        int sum = 0;
//        for (int i = 0, count = 0; i < edges.length && count < points.length - 1; i++) {
//            int[] edge = edges[i];
//            if (find(edge[0], parent) == find(edge[2], parent)) continue;
//            sum += edge[1];
//            union(edge[0], edge[2], parent);
//            count++;
//        }
//        return sum;
//    }
//
//    public int getDistance(int[] point1, int[] point2) {
//        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
//    }
//
//    public int find(int value, int[] parent) {
//        if (parent[value] != value) {
//            parent[value] = find(parent[value], parent);
//        }
//        return parent[value];
//    }
//
//    public void union(int a, int b, int[] parent) {
//        int rootA = find(a, parent);
//        int rootB = find(b, parent);
//        if (rootB == rootA) return;
//        parent[rootA] = rootB;
//    }
//}


/**
 * Prim
 */
class Solution {
    public int minCostConnectPoints(int[][] points) {
        // 权值数组
        int[] path = new int[points.length];
        // 被访问数组
        int[] visited = new int[points.length];
        // 标记数组，是否被访问
        boolean[] mark = new boolean[points.length];
        mark[0] = true;
        // 初始化，将所有权值设为无限大，被访问节点都是自己
        for (int i = 0; i < points.length; i++) {
            path[i] = 0x3f3f3f3f;
            visited[i] = i;
        }

        // 建图
        int[][] edges = new int[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                edges[i][j] = getDistance(points[i], points[j]);
            }
        }
        // 预启动，寻找第一个最小值
        for (int i = 0; i < points.length; i++) {
            // 更新path信息
            path[i] = edges[0][i];
            // 更新visited信息
            visited[i] = 0;
        }

        int vertex = 0;
        int sum = 0;
        // 一共有points.length条边
        for (int i = 1; i < points.length; i++) {
            // 最小值
            int min = 0x3f3f3f3f;
            // 在未被标记的节点中寻找最小值
            for (int j = 0; j < points.length; j++) {
                if (mark[j] || min < path[j]) continue;
                // 最小值
                min = path[j];
                // 激活点
                vertex = j;
            }
            mark[vertex] = true;
            sum += min;
            // 激活了新节点，更新path和visited信息
            for (int j = 0; j < points.length; j++) {
                // 如果未被标记并且权值小于path记录的权值
                if (!mark[j] && edges[vertex][j] < path[j]) {
                    path[j] = edges[vertex][j];
                    visited[j] = vertex;
                }
            }
        }

        return sum;
    }

    public int getDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}