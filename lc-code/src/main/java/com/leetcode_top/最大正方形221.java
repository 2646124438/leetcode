package com.leetcode_top;

public class 最大正方形221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Math.min(m, n);
        int maxArea = 0;
        for(int l=min;l>=1;l--){
            for(int i=0;i<=m-l;i++){
                for(int j=0;j<=n-l;j++){
                    boolean hasSquare = true;
                    if(matrix[i][j]=='0'){
                        continue;
                    }
                    for(int sqL=0;sqL<l;sqL++) {
                        for(int sq = 0; sq < l; sq++) {
                            if (!(matrix[i + sqL][j+sq] == '1')) {
                                hasSquare = false;
                                break;
                            }
                        }
                        if(!hasSquare) break;
                    }
                    if(hasSquare){
                       return l*l;
//                       break;
                    }
                }
            }
        }
        return maxArea;
    }

    //dp 解法
    // dp[i][j] = 1. nums[i][j]==0:max(dp[i-1][j], dp[i][j-1])
//                2. nums[i][j]=='1':
//                  if nums[i-sqrt(dp[i-1][j-1]):i][j]=='1'&&nums[i][j-sqrt(dp[i-1][j-1]):j]=='1'
//                        dp[i][j] = dp[i-1][j-1]+1;
//    public int maximalSquare2(char[][] matrix) {
//
//    }
    public static void main(String[] args) {
        char[][] arr = new char[4][5];
        arr[0] = new char[]{'1','0','1','0','0'};
        arr[1] = new char[]{'1','0','1','1','1'};
        arr[2] = new char[]{'1','1','1','1','1'};
        arr[3] = new char[]{'1','0','0','1','0'};
        arr = new char[2][2];
        arr[0] = new char[]{'0','1'};
        arr[1] = new char[]{'1','0'};
        new 最大正方形221().maximalSquare(arr);
    }
}
