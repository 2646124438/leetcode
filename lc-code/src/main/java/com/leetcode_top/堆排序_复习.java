package com.leetcode_top;

public class 堆排序_复习 {
    //1.buildHeap
    //2.　adjustHeap
    public void sort(int[] nums){
        if(nums==null||nums.length<=1){
            return;
        }
        //1.构建大顶堆
        buildMaxHeap(nums);
        //2.
        for(int i=nums.length-1;i>=0;i--){
            exchageElment(nums, 0, i);//交换堆顶和第0位置元素
            maxHeap(nums, 0, i);//因为交换元素，违反堆的性质，所以沉降元素
        }
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        System.out.println("aaaaaaaaaaaaaaaaaaa");
    }
    public void buildMaxHeap(int[] nums){
        if(nums==null||nums.length<=1){
            return;
        }
        int half = nums.length/2;
        for(int i=half;i>=0;i--){
            maxHeap(nums, i, nums.length);
        }
    }

    public void maxHeap(int[] nums,int index, int heapSize){
        int left = 2*index+1;//左子树元素
        int right = 2*index+2;//右子树元素
        int largest = index;//初始化最大元素
        if(left<heapSize&&nums[left]>nums[index]){
            largest = left;
        }
        if(right<heapSize&&nums[right]>nums[largest]){
            largest = right;
        }
        if(index!=largest){//判断根元素是否为最大元素
            exchageElment(nums, index, largest);//
            maxHeap(nums, largest, heapSize);
        }
    }

    public void exchageElment(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
//        [3,2,3,1,2,4,5,5,6]

        new 堆排序_复习().sort(nums);
    }
}
