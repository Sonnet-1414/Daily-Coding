package com.lullaby.greed.lc1323;

class Solution {
    public int maximum69Number (int num) {
        String string = "" + num;
        String ans = "";
        boolean mark = false;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == '6') {
                ans += string.substring(0, i);
                ans += '9';
                ans += string.substring(i + 1, string.length());
                mark = true;
                break;
            }
        }
        if (!mark) ans = string;
        return (int)Integer.parseInt(ans);
    }
}
