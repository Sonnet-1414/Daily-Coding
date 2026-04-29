package com.lullaby.simulation.lc2996;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingInteger(int[] nums) {
        Set set = new HashSet();
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }
        for (int num : nums) {
            set.add(num);
        }
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}