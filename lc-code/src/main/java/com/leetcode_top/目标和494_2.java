package com.leetcode_top;

public class 目标和494_2 {
    // dp[i][S] = dp[i-1][S-nums[i]] + dp[i-1][S+nums[i]]
    public int findTargetSumWays(int[] nums, int S) {
        int sum = Math.abs(S);
        int[][] dp = new int[nums.length][2*Math.abs(S)+1];
        dp[0][nums[0]] = 1;
        dp[0][2*nums[0]] = 1;
        for(int i=0;i<nums.length;i++){
            for(int j = 0; j<=Math.abs(2*S);j++){
                dp[i][j] = j>=nums[i]?dp[i][sum+j-nums[i]]:0+dp[i][sum+j+nums[i]];
            }
        }
        System.out.println(dp[nums.length-1][S+Math.abs(S)]);
        return dp[nums.length-1][S+Math.abs(S)];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100};
        int S = -100;
        int result = new 目标和494_2().findTargetSumWays(nums, S);
    }
}
