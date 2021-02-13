package com.leetcode_topic.sort;

import java.util.*;

public class KthFreqElement {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        for(int num:nums){
            mapFreq.put(num, mapFreq.getOrDefault(num, 0)+1);
        }
        List<int[]> value = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry:mapFreq.entrySet()){
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            value.add(new int[]{num, count});
        }
        sort(value, 0, value.size()-1, k-1);
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = value.get(i)[0];
        }
        return result;
    }

    public void sort(List<int[]> valueList, int left, int right, int k){
        int start = left;
        int end = right;
        int[] tem = valueList.get(left);
        int currKey = valueList.get(left)[1];
        while(left<right){
            if(left<right&&valueList.get(right)[1]<=currKey){
                right--;
            }
            valueList.set(left, valueList.get(right));
            if(left<right&&valueList.get(left)[1]>=currKey){
                left++;
            }
            valueList.set(right, valueList.get(left));
        }
        valueList.set(left, tem);
        if(left==k){
            return;
        }else if(left>k){
            sort(valueList, start, left-1, k);
        }else if(left<k){
            sort(valueList, left+1, end, k);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        nums = new int[]{1};
        int k = 1;
        int[] result = new KthFreqElement().topKFrequent(nums, k);
        Arrays.stream(result).forEach(i->{
            System.out.println(i+",");
        });
    }
}
