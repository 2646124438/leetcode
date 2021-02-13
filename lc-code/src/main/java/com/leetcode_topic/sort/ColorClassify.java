package com.leetcode_topic.sort;

import java.util.HashMap;
import java.util.Map;

public class ColorClassify {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        for(int num:nums){
            mapFreq.put(num,mapFreq.getOrDefault(num, 0)+1);
        }
        int[] numSet = new int[mapFreq.size()];
        int[] numCount = new int[mapFreq.size()];
        int idx = 0;
        for(Map.Entry<Integer, Integer> entry:mapFreq.entrySet()){
            numSet[idx] = entry.getKey();
            numCount[idx] = entry.getValue();
        }
        for(int i=0;i<3;i++){
            if(mapFreq.containsKey(i)){
                int value = mapFreq.get(i);
                for(int j=0;j<value;j++){
                    nums[idx] = i;
                    idx++;
                }
            }
        }
    }

}
