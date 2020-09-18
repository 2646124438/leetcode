package com.jiangli.dp;

public class PatternMatch {
    // dp思想，从后往前推。思考构建 dp状态转移方程
    // 参考思路： https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode-solution/

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for(int i=0;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                String p_char = p.charAt(j-1)+"";
                String s_char = i>0?s.charAt(i-1)+"":"";
                if(p_char.equals("*")) {
                    dp[i][j] = dp[i][j-2];
                    p_char = p.charAt(j-2)+"";
                    if(i>0&&(p_char.equals(s_char)||p_char.equals("."))){
                        dp[i][j] = dp[i][j]||dp[i-1][j];
                    }
                }else{
                    p_char = p.charAt(j-1)+"";
                    if (i>0&&(s_char.equals(p_char) || p_char.equals("."))){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
//        ""
//".*"
        System.out.println(new PatternMatch().isMatch("", ".*"));
    }
}
