package com.leetcode_top;

import java.util.Arrays;
import java.util.List;

public class 单词拆分139 {
    //使用Dp解决，思考简历建　状态方程
    // dp[j] =(dp[i] && wordDict.contains(s.substring(j-i, j));  // j>i,从小到大就可以

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
//        dp[1] =
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                dp[i] =dp[j] && wordDict.contains(s.substring(j, i));
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("leet","code");
        new 单词拆分139().wordBreak("leetcode", wordDict);
    }
}
