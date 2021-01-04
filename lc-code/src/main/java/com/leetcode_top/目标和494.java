package com.leetcode_top;

public class 目标和494 {
    private int operationComboCount = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int length = nums.length;
        if(length==0){
                return 0;
        }
        backTr(nums, 0, S, 0, length);
        return this.operationComboCount;
    }

    public void backTr(int[] nums, int index, int S, int tempSum, int length){
        if(index==length){
            if(tempSum==S){
                this.operationComboCount+=1;
            }
            return;
        }
        tempSum+=nums[index];
        backTr(nums, index+1, S, tempSum, length);
        tempSum-=nums[index];

        tempSum-=nums[index];
        backTr(nums, index+1, S, tempSum, length);
        tempSum+=nums[index];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100};
        int S = -100;
        int result = new 目标和494().findTargetSumWays(nums, S);
        System.out.println(result);
    }
}
