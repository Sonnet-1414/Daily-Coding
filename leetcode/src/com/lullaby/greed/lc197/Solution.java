package com.lullaby.greed.lc197;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        // 将每个数字转换成字符串
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
//        Arrays.sort(strs, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                String order1 = o1 + o2;
//                String order2 = o2 + o1;
//                return order2.compareTo(order1);
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//                return false;
//            }
//        });

        Arrays.sort(strs, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));

        StringBuilder stringBuilder = new StringBuilder();
        for(String string : strs) {
            stringBuilder.append(string);
        }

        return stringBuilder.charAt(0) == '0' ? "0" : stringBuilder.toString();
    }
}
