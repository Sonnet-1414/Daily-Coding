package com.lullaby.greed.lc1338;

import java.util.*;

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int num = map.getOrDefault(i, 0);
            num++;
            map.put(i, num);
        }
        List<Integer> count = new ArrayList<>(List.of(map.values().toArray(new Integer[0])));
        count.sort((o1, o2) -> o2.compareTo(o1));
        int ans = 0;
        int s = 0;
        for (int i : count) {
            s += i;
            ans++;
            if (s * 2 >= arr.length) {
                break;
            }
        }
        return ans;
    }
}
