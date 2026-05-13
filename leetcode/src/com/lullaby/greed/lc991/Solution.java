package com.lullaby.greed.lc991;

/**
 * 正向
 * O(log(target))
 */
//class Solution {
//    public int brokenCalc(int startValue, int target) {
//        if (target <= startValue) {
//            return startValue - target;
//        }
//        int step = 0;
//        while (startValue < target) {
//            startValue <<= 1;
//            step++;
//        }
//
//        int dif = startValue - target;
//        double max = Math.pow(2, step);
//        while (dif != 0) {
//            while (max > dif) {
//                max /= 2;
//            }
//            dif -= max;
//            step++;
//        }
//
//        return step;
//    }
//}


/**
 * 逆向
 * O(log(n))
 */
class Solution {
    public int brokenCalc(int startValue, int target) {
        int step = 0;
        while (target > startValue) {
            step++;
            if (target % 2 == 1) {
                target += 1;
            } else {
                target /= 2;
            }
        }
        return step + startValue - target;
    }
}
