package com.lullaby.greed.lc316;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] mark = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']--;
            if (mark[c - 'a']) {
               continue;
            } else {
                while (!stack.isEmpty() && stack.charAt(stack.length() - 1) > c && count[stack.charAt(stack.length() - 1) - 'a'] > 0) {
                    mark[stack.charAt(stack.length() - 1) - 'a'] = false;
                    stack.deleteCharAt(stack.length() - 1);
                }
                mark[c - 'a'] = true;
                stack.append(c);
            }
        }

        return stack.toString();
    }
}
