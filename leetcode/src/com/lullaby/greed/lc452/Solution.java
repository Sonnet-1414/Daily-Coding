package com.lullaby.greed.lc452;

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> o1[0] - o2[0]);
        int count = 1;
        int start = points[0][0];
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] >= start && points[i][0] <= end) {
                start = points[i][0];
                end = Math.min(end, points[i][1]);
            } else {
                count++;
                start = points[i][0];
                end = points[i][1];
            }
        }

        return count;
    }
}