package com.lullaby.greed.lc1029;

import java.util.Arrays;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (((o1, o2) -> o1[0] - o1[1] - o2[0] + o2[1])));
        int ans = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            ans += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            ans += costs[i][1];
        }
        return ans;
    }
}
