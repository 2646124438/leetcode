package com.leetcode_top;

public class 接雨水42 {
    public int trap(int[] height) {
        int area = 0;
        int ans = 0;
        for(int i=1;i<height.length;i++){
            int maxLeft = 0;
            int maxRight = 0;
            for(int j=i;j>=0;j--){
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for(int j=i;j<height.length;j++){
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxRight, maxLeft)-height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        new 接雨水42().trap(arr);
    }
}
