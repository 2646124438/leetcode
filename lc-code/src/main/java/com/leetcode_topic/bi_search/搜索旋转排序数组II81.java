package com.leetcode_topic.bi_search;

public class 搜索旋转排序数组II81 {
    //    假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
    //    编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
    //      分析　target所在区间，也要分析nums[mid]所在位置．
    //          1. nums[mid]>nums[left] && target<nums[mid],  right = mid; else: left = mid
    //          2. nums[mid]<nums[left]
    //                  if(target>nums[mid]&&target<nums[right]): left = mid;
    //                  else: right = mid;
    //          3. nums[mid] == target: return true;
    //          4. if left>=right&&nums[mid]!=target: return false;
    public boolean search(int[] nums, int target) {
        int right = nums.length-1;
        int left = 0;
        while(left<=right){
            int mid = (left+right)>>1;
            if(nums[mid]==target||nums[right]==target||nums[left]==target){
                return true;
            }
            if(nums[mid]==nums[left]){
                left++;
                continue;
            }
            if(nums[mid]>nums[left]){
                if(target<nums[mid]&&target>=nums[left]){
                    right = mid;
                }else{
                    left = mid;
                }
                continue;
            }else if(nums[mid]<nums[left]){
                if(target>nums[mid]&&target<=nums[right]){
                    left = mid;
                }else{
                    right = mid;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target= 0;
        nums = new int[]{1};
        target = 1;
        boolean result = new 搜索旋转排序数组II81().search(nums, target);
        System.out.println(result);
    }
}
