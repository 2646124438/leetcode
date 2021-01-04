package com.leetcode_top;

public class 柱状图中最大的矩形84_类似接雨水 {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0) return 0;
        int max = heights[0];
        for(int i=0;i<heights.length;i++){
            int num = heights[i];
            int l = i-1;
            int r = i+1;
            for(l=i;l>=0;l--){
                if(heights[l]<num){
                    break;
                }
            }
            for(r=i;r<heights.length;r++){
                if(heights[r]<num){
                    break;
                }
            }
            int max_candi = num*(r-l-1);
            if(max<max_candi){
                max = max_candi;
            }
        }
        return max;
    }
}
