package com.jiangli.leetcode.top100;

public class MaxSubSum {

    public int maxSubSum(int[] nums){
        if(nums.length==0)return 0;

        int[] itemSum = new int[nums.length];
        itemSum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            itemSum[i] = nums[i]+itemSum[i-1];
        }
        int l = 0;
        int r = nums.length-1;
        int max = Integer.MIN_VALUE;
        while(l<r){
            int temp = itemSum[r]-itemSum[l];
            if(temp>max){
                max = temp;
            }
            if(itemSum[l]>itemSum[l+1]){
                l++;
            }
            if(itemSum[r]<itemSum[r-1]){
                r--;
            }
        }
        return max;
    }
}
