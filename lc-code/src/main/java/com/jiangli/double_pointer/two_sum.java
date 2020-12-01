package com.jiangli.map;

import java.util.*;

public class two_sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numsIdxMap = new HashMap<Integer, List<Integer>>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            if(numsIdxMap.containsKey(nums)){
                numsIdxMap.get(nums[i]).add(i);
            }else{
                numsIdxMap.put(nums[i], new ArrayList<Integer>(Arrays.asList(i)));
            }
        }
        for(int i=0;i<nums.length;i++){
            int left = target-nums[i];
            if(numsIdxMap.containsKey(left)&&numsIdxMap.get(left).get(0)!=i){
                result[0]= i;
                result[1] = numsIdxMap.get(left).get(0);
             break;
            }
        }
        return result;
    }
}
