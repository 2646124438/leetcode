package com.leetcode_topic.bi_search;

public class 有序数组中的单一元素540 {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = -1;

//        3,3,7,7,10,11,11
        while(left<=right){
            mid = (left+right)>>1;
            if((mid==0||nums[mid]!=nums[mid-1])
                    &&(mid==nums.length-1||nums[mid]!=nums[mid+1])){
                break;
            }
            if((mid+1)%2==0){
                if(nums[mid]==nums[mid-1]) {
                    left = mid+1;
                }else if(nums[mid]==nums[mid+1]){
                    right = mid-1;
                }
            }else{
                if(nums[mid]==nums[mid-1]){
                    right = mid-2;
                }else if(nums[mid]==nums[mid+1]){
                    left = mid+2;
                }
            }
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3,3,4,4,8,8};
//        nums = new int[]{3,3,7,7,10,11,11};
//        nums = new int[]{1};
        int result = new 有序数组中的单一元素540().singleNonDuplicate(nums);
        System.out.println(result);
    }
}
