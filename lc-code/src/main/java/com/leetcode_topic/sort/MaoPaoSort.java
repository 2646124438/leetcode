package com.leetcode_topic.sort;

public class MaoPaoSort {
    public int[] sort(int[] nums){
        boolean swaped = false;
        for(int i=1;i<nums.length;i++){
            swaped = false;
            for(int j=1;j<nums.length-i-1;j++){
                if(nums[j]>nums[j-1]){
                    swap(nums, j, j-1);
                    swaped = true;
                }
            }
            if(!swaped){
                break;
            }
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
