package com.leetcode_top;

import java.util.Arrays;
import java.util.Stack;

public class 柱状图中最大的矩形84_单调栈 {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0) return 0;
//        int max = heights[0];
        int[] tmp = new int[heights.length+2];
        System.arraycopy(heights, 0, tmp ,1, heights.length);
        Stack<Integer> stack = new Stack<Integer>();
        int area = 0;
        //对下标进行入栈
        for(int i=0;i<tmp.length;i++){
            while(!stack.isEmpty()&&tmp[i]<tmp[stack.peek()]){
                int w = i-stack.peek();
                int h = tmp[stack.pop()];
                area = Math.max(area, w*h);
            }
            stack.push(i);
        }
        return area;
    }

    public int largetRectangleArea2(int [] heights){
        int n = heights.length;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(right, n);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty()&&heights[i]<heights[stack.peek()]){
                int l = stack.pop();
                right[l] = i;
            }
            left[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, (right[i]-left[i]-1)*heights[i]);
        }
        return max;
    }
}
