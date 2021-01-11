package com.leetcode_topic.tanxin;

public class 非递减数列665 {

    //给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
    //
    //我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
    // 拐点算法
    public boolean checkPossibility(int[] nums) {
        int num =0 ;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                num++;
                if(i==1||nums[i]>=nums[i-2]){
                    nums[i-1] = nums[i];
                }else{
                    nums[i] = nums[i-1];
                }
            }
        }
        return num<=1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,1};
        boolean result = new 非递减数列665().checkPossibility(nums);
        System.out.println(result);
    }
}
