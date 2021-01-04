package com.leetcode_top;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 和为K的子数组560 {
    private int arraySumCount = 0;
    public int subarraySum(int[] nums, int k) {
        int subArraySumK = 0;
        int[] numSums = new int[nums.length+1];
        numSums[0] = 0;
        HashMap<Integer, Integer> numSumMap = new HashMap<>();
        numSumMap.put(0,1);
        for(int i=1;i<numSums.length;i++){
            numSums[i] = numSums[i-1]+nums[i-1];
            if(numSumMap.containsKey(numSums[i]-k)){
                subArraySumK += numSumMap.get(numSums[i]-k);
            }
            numSumMap.put(numSums[i], numSumMap.getOrDefault(numSums[i],0)+1);
        }
        return subArraySumK;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        int k=2;
        int result = new 和为K的子数组560().subarraySum(nums, k);
        System.out.println(result);
    }
}
