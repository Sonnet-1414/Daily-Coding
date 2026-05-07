package com.lullaby.greed.lc11;

class Solution {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;
        int maxV = 0;
        while (p1 < p2) {
            maxV = Math.max(maxV, getV(p1, p2, height));
            if (height[p1] < height[p2])
                p1++;
            else p2--;
        }

        return maxV;
    }

    public static int getV(int p1, int p2, int[] height) {
        return Math.abs(p2 - p1) * Math.min(height[p1], height[p2]);
    }
}