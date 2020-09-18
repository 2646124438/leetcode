package com.jiangli.bag01;

import java.util.Scanner;
import java.lang.Math;
public class Bag01 {

    // 01背包问题
    // 描述:给定 n 件物品，物品的重量为 w[i]，物品的价值为 c[i]。现挑选物品放入背包中，假定背包能承受的最大重量为 V，问应该如何选择装入背包中的物品，使得装入背包中物品的总价值最大？
    public void bag01(){
        Scanner input = new Scanner(System.in);
        int v = input.nextInt();
        int n = input.nextInt();
        int[] w = new int[n];
        int[] c = new int[n];
        for(int i=0;i<n;i++){
            w[i] = Integer.parseInt(input.next());
            c[i] = Integer.parseInt(input.next());
        }

        int[][] dp = new int[n][v+1];
        // 初始化
        dp[0][w[0]] = c[0];
        // 行i是 物品, 列j是v, dp[i][j]是价值
        // 状态转移   dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i]]+c[i])
        for(int i=0;i<w.length;i++){
            for(int j=1;j<=v;j++){
                if(v-j<w[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][v - j] + c[i]);
                }
            }
        }

    }


    //#416 分割等和子集
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total+= nums[i];
        }
        if(total%2!=0){
            return false;
        }
        int half = total/2;
        boolean[][] dp = new boolean[nums.length][half+1];
        if(nums[0]>half){
            dp[0][nums[0]] = true;
        }
        // 转移方程: dp[i][j] = dp[i-1][j] or dp[i-1][j-nums[i]]
        for(int i=0;i<nums.length;i++){
            for(int j=half;j>0;j--){
                dp[i][j] = dp[i-1][j];
                if(j==nums[i]){
                    dp[i][j] = true;
                    continue;
                }
                if(j>nums[i]){
                    dp[i][j] = dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][half];
    }
    // #416 分割等和子集, 优化空间复杂度
    public boolean canPartition2(int[] nums){
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total+= nums[i];
        }
        if(total%2!=0){
            return false;
        }
        int half = total/2;
        boolean[] dp = new boolean[half+1];
        if(nums[0]>half){
            dp[nums[0]] = true;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=half; j>nums[i];j++){
                if(j==nums[i]){
                    return true;
                }
                dp[j] = dp[j-nums[i]];
            }
        }
        return dp[half];
    }
}
