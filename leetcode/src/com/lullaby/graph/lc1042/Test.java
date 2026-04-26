package com.lullaby.graph.lc1042;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] path = {{1,2},{2,3},{3,1}};
        int[][] path = {{1,2},{3,4}};
        int[] ans = solution.gardenNoAdj(4, path);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
