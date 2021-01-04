package com.leetcode_top;

public class 堆排序_复习2 {
    public void sort(int[] nums){
        buildHeap(nums);
        for(int i = nums.length;i>=0;i--){
            swap(nums, 0, i);
            adjustHeap(nums, i, nums.length);
        }
    }

    public void buildHeap(int[] nums){
        int length = nums.length;
        int half = length/2;
        for(int i=half;i>=0;i--){
            adjustHeap(nums, i, length);
        }
    }

    public void adjustHeap(int[] nums, int index, int heapSize){
        int leftIndex = 2*index+1;
        int rightIndex = 2*index+2;
        int largestIndex = index;
        if(leftIndex<heapSize&&nums[leftIndex]>nums[index]){
            largestIndex = leftIndex;
        }
        if(rightIndex<heapSize&&nums[rightIndex]>largestIndex){
            largestIndex = rightIndex;
        }
        if(index!=largestIndex){
            swap(nums, index, largestIndex);
            adjustHeap(nums, largestIndex, heapSize);
        }
    }

    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
