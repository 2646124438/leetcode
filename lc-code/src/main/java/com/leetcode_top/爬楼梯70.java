package com.leetcode_top;

public class 爬楼梯70 {
    int result = 0;
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        for(int i=2;i<dp.length;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
