package com.leetcode_top;

public class 数组中的第k个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0, nums.length-1, k-1);
    }

    public int quickSort(int[] nums, int start, int end, int k){
        int left = start;
        int right = end;
        int ref = nums[left];
        while(left<right){
            while(nums[right]>=ref){
                right--;
            }
            swap(nums, left, right);
            while(nums[left]<=ref){
                left++;
            }
            swap(nums, left, right);
            ref = nums[left];
        }
        if(k==left){
            return nums[left];
        }else if(k<=left-1){
            return quickSort(nums, start, left-1, k);
        }else{
            return quickSort(nums, left+1 ,end, k);
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(new 数组中的第k个最大元素().findKthLargest(nums, 4));
    }
}
