package com.lullaby.greed.lc807;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid[0].length];
        int[] colMax = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);

            }
        }

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return ans;
    }
}