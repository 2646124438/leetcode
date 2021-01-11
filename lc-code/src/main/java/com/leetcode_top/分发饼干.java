package com.leetcode_top;

import java.util.Arrays;

public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childNum = 0;
        int sStart = 0;
        for(int i=0;i<g.length;i++){
            int gItem = g[i];
            int j = sStart;
            for(;j<s.length;j++){
                if(gItem<=s[j]){
                    childNum+=1;
                    j++;
                    break;
                }
            }
            sStart = j;
        }
        return childNum;
    }
}
