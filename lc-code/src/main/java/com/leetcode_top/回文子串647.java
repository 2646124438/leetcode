package com.leetcode_top;

public class 回文子串647 {
    public int countSubstrings(String s) {
        int length = s.length();
        int count = 0;
        for(int i=0;i<length;i++){
                count+=getItemLen(s, 0, i, i+1);
                count+=getItemLen(s,0, i, i);
        }
        return count;
    }

    public int countSubstrings2(String s){
        int length = s.length();
        int ans = 0;
        boolean[][] dp = new boolean[length][length];
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)&&(i+2>j||dp[i+1][j-1])){
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    public int getItemLen(String s, int itemLen, int left,int right){
        while(left-itemLen>=0&&right+itemLen<s.length()){
            if(s.charAt(left-itemLen)==s.charAt(right+itemLen)){
                itemLen+=1;
            }else{
                break;
            }
        }
        return itemLen;
    }

    public static void main(String[] args) {
        System.out.println(new 回文子串647().countSubstrings2("aaa"));
    }
}
