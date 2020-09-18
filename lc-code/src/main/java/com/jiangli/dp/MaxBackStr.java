package com.jiangli.dp;

public class MaxBackStr {
//    最长回文子串  #leetcode 5
    //回文考虑从i,j判断是否为回文
    //状态转移 s[i][j] = s[i+1][j-1] 此处关键考虑填表顺序
    public String longestPalindrome(String s) {
        String result = "";
        if(s.isEmpty()||s.length()==1) return s;
        int m = s.length();
        int center = m/2;
        boolean[][] dp = new boolean[m+1][m+1];
        dp[0][0] = true;
        int max = -1;
        int best_i = 0;
        int best_j = 1;
        for(int i=0;i<m;i++){
            dp[i][i] = true;
            max = 0;
        }
        for(int j=1;j<m;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)!=s.charAt(j)) {
                    dp[i][j] = false;
                }else if(s.charAt(i)==s.charAt(j)&&j-i<=2){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = dp[i+1][j-1];
                }
                if(dp[i][j]&&j-i>max){
                    max = j-i;
                    best_i = i;
                }
            }
        }
        result = s.substring(best_i, best_i+max+1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxBackStr().longestPalindrome("aaaa"));
    }
}
