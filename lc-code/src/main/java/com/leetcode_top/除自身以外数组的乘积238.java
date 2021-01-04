package com.leetcode_top;

public class 除自身以外数组的乘积238 {
    public int[] productExceptSelf(int[] nums) {
       int[] answer = new int[nums.length];
       answer[0] = 1;
       for(int i=1;i<nums.length;i++){
           answer[i] = answer[i-1]*nums[i-1];
       }
       int R = 1;
       for(int i=nums.length-1;i>=0;i--){
           answer[i] = answer[i]*R;
           R *= nums[i];
       }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        int[] result = new 除自身以外数组的乘积238().productExceptSelf(arr);
    }
}
