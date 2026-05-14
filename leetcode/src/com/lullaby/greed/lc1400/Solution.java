package com.lullaby.greed.lc1400;

class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) return false;
        int[] mark = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mark[c - 'a']++;
        }
        int count = 0;
        for (int i : mark) {
            if (i % 2 == 1) {
                count++;
            }
        }
        if (count > k) return false;
        return true;
    }
}
