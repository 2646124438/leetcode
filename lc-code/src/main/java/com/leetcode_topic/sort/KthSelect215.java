package com.leetcode_topic.sort;

//huo
public class KthSelect215 {

    public int getKth(int[] nums, int k){
        return getKth(nums, k-1, 0, nums.length-1);
    }
    public int getKth(int[] nums, int k, int left, int right){
        int start = left;
        int end = right;
        int currKey = nums[left];
        while(left<right){
            while(left<right&&currKey>=nums[right]){
                right--;
            }
            nums[left] = nums[right];
            while(left<right&&currKey<=nums[left]){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = currKey;
        if(left==k){
            return nums[left];
        }else if(left>k){
            return getKth(nums, k, start, left-1);
        }else if(left<k){
            return getKth(nums, k, left+1, end);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int result = new KthSelect215().getKth(nums, 2);
        System.out.println(result);
    }
}
