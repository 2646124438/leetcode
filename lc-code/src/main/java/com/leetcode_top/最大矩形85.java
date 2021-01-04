package com.leetcode_top;

import java.util.Arrays;
import java.util.Stack;

public class 最大矩形85 {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        if(m==0)return 0;
        int n=matrix[0].length;
        int maxArea = 0;
        int[] height = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<m;i++){
            stack.clear();
            for(int j=0;j<n;j++){
                height[j] = matrix[i][j]=='0'?0:height[j]+1;
            }
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(right, n);
            for(int j=0;j<height.length;j++){
                while(!stack.isEmpty()&&height[j]<height[stack.peek()]){
                    int l = stack.pop();
                    right[l] = j;
                }
                left[j] = stack.isEmpty()?-1:stack.peek();
                stack.push(j);
            }
            for(int j=0;j<height.length;j++){
                maxArea = Math.max(maxArea, (right[j]-left[j]-1)*height[j]);
            }
        }
        return maxArea;
    }
}
