package com.leetcode_top;

public class 移动零283 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while(right<nums.length){
            if(nums[right]!=0){
                nums[left] = nums[right];
                right++;
                left++;
            }else {
                right++;
            }
        }
        while(left<nums.length){
            nums[left] = 0;
            left++;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        new 移动零283().moveZeroes(arr);
    }
}
