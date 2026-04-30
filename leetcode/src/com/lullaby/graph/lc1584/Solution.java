package com.lullaby.graph.lc1584;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        boolean[] mark = new boolean[points.length];
        mark[0] = true;
        List<List<List<Integer>>> edges = new ArrayList<>();
//        int sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            edges.add(new ArrayList<>());
//            int min = 0;
//            int temp = 0;
            for (int j = 0; j < points.length - 1; j++) {
                if (i == j) continue;
                int distance = getDistance(points[i], points[j]);
//                if (min == 0) {
//                    min = distance;
//                    temp = j;
//                } else {
//                    if (min > distance) {
//                        temp = j;
//                        min = distance;
//                    }
//                }
                List<Integer> edge = new ArrayList<>(List.of(i, distance, j));
                edges.get(i).add(new ArrayList<>(edge));
            }
//            sum += min;
//            mark[temp] = true;
        }


//        return sum;
    }

    public int getDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}