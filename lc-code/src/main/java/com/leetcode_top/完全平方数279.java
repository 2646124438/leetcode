package com.leetcode_top;

public class 完全平方数279 {
    public int numSquares(int n) {
        // dp[n] = min{dp[n-i*i]+dp[i*i]}; i从1-max
        int itemMax = (int)Math.sqrt((double)n);
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int item=1;item<=itemMax;item++){
            dp[item*item] = 1;
        }
        getMin(dp, n);
        return dp[n];
    }

    public void getMin(int[] dp, int target){
//        if(target==0){
////            dp[target] = 1;
//            return ;
//        }
        for(int i=1;i<=target;i++){
            int itemMax = (int)Math.sqrt((double)i);
            int min = Integer.MAX_VALUE;
            for(int item=1;item<=itemMax;item++){
//                getMin(dp, i-item*item);
                min = Math.min(dp[i-item*item]+dp[item*item], min);
            }
            dp[i] = min;
        }
    }

    public static void main(String[] args) {
        new 完全平方数279().numSquares(27);
    }
}
