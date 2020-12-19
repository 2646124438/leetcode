package com.leetcode_top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集78 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        for(int i=0;i<length;i++) {
            if(i==0){
                result.add(new ArrayList<Integer>());
                continue;
            }
            dfs(nums, 0, i, new ArrayList<Integer>());
        }
        return result;
    }

    public void dfs(int[] nums, int index, int count, List<Integer> item){
        if(item.size()==count){
            List<Integer> temp = new ArrayList<Integer>(item);
            this.result.add(temp);
            return ;
        }
        for(int i=index;i<nums.length;i++){
            if(!item.contains(nums[i])){
                item.add(nums[i]);
                dfs(nums, i+1, count, item);
                item.remove(item.size()-1);
            }
        }

    }
}
