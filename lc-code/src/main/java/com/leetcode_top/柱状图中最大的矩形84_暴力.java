package com.leetcode_top;

public class 柱状图中最大的矩形84_暴力 {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<length-1;i++){
            if(i==2){
                System.out.println("a");
            }
            for(int j=i; j<length;j++){
                int width = j - i + 1 ;
                int min = getMin(i, j, heights);
                if(width*min>max){
                    max = width*min;
                }
            }
        }
        return max;
    }

    public int getMin(int s, int e, int[] heights){
        Integer min = Integer.MAX_VALUE;
        for(int i=s;i<=e;i++){
            if(heights[i]<min){
               min = heights[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] heights=  new int[]{2,1,5,6,2,3};
        new 柱状图中最大的矩形84_暴力().largestRectangleArea(heights);
    }
}
