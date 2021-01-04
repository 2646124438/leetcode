package com.leetcode_top;

import java.util.ArrayList;
import java.util.List;

public class 找打数组中消失的数字448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disNumber = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int numI = Math.abs(nums[i]);
            if(nums[numI-1]>0) {
                nums[numI - 1] *= -1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                disNumber.add(i+1);
            }
        }
        return disNumber;
    }
}
