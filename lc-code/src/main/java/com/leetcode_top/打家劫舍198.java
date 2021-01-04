package com.leetcode_top;

import java.util.Arrays;

public class 打家劫舍198 {
    //涉及到最值问题，使用dp,
    // dp[i] = max(dp[i-1], dp[i-2]+nums[i]);
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        System.arraycopy(nums, nums.length, dp, 0, nums.length);
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1], i<2?0:dp[i-2]+nums[i]);
        }
        return dp[nums.length];
    }
}
