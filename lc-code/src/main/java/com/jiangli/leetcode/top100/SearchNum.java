package com.jiangli.leetcode.top100;

public class SearchNum {
    //统计数字在有序数组中的最大次数
    public int search(int[] nums, int target) {
        if(target<nums[0]||target>nums[nums.length-1]){
            return 0;
        }
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                count++;
            }
            if(nums[i]>target){
                break;
            }
        }
        return count;
    }

}
