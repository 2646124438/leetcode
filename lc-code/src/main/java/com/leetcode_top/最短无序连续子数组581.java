package com.leetcode_top;

import java.util.Arrays;

public class 最短无序连续子数组581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int left = 0;
        int right = 0;
        boolean getleft = false;
        boolean getright = false;
        for(int i=0;i<nums.length;i++){
            if(!getleft&&sortedNums[i]!=nums[i]){
                left = i;
                getleft = true;
            }
            if(!getright&&
                    sortedNums[nums.length-1-i]!=nums[nums.length-1-i]){
                right = nums.length-1-i;
                getright = true;
            }
            if(getleft&&getright){
                break;
            }
        }
        return getleft&&getright?right-left+1:0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,6,4,8,10,9,15};
        nums = new int[]{2,1,3,4,5};
        int result = new 最短无序连续子数组581().findUnsortedSubarray(nums);
        System.out.println(result);
    }
}
