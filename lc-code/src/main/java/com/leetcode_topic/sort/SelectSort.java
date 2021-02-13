package com.leetcode_topic.sort;

public class SelectSort {
    public int[] sort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int mid = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[mid]){
                    mid = j;
                }
            }
            swap(nums, i, mid);
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
