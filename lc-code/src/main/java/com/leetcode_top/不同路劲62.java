package com.leetcode_top;

public class 不同路劲62 {
    public int uniquePaths(int m, int n) {
        int count = 0;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        dp[1][1] = 1;
        for(int i=1;i<m+1;i++){
            dp[i][1] =1;
        }
        for(int j=1;j<n+1;j++){
            dp[1][j] =1;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        count = dp[m][n];
        //核心是要找出转移方程 dp[i][j] = dp[i-1][j]+d[i][j-1]

        return count;
    }
}
