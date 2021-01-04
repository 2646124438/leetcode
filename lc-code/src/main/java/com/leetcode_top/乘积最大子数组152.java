package com.leetcode_top;

public class 乘积最大子数组152 {


    //因为乘法需要考虑正负号，所以要考虑最大最小值
    // dpmax[i] = max(dpmax[i-1]*nums[i], dpmin[i-1]*nums[i], nums[i])
    // dpmin[i] = min(dpmin[i-1]*nums[i], dpmin[i-1]*nums[i], nums[i])
    public int maxProduct(int[] nums) {
        int[] maxdp = new int[nums.length+1];
        maxdp[0] = 1;
        int[] mindp = new int[nums.length+1];
        mindp[0] = 1;
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
                maxdp[i+1] = Math.max(maxdp[i]*nums[i], Math.max(mindp[i]*nums[i], nums[i]));
                mindp[i+1] = Math.min(maxdp[i]*nums[i], Math.min(mindp[i]*nums[i], nums[i]));
            max = Math.max(max, maxdp[i+1]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,-1,4};
        new 乘积最大子数组152().maxProduct(nums);
    }
}
