package com.leetcode_top;

import java.util.ArrayList;
import java.util.List;

public class 全排列46 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        back(nums, new ArrayList<>(), used);
        return this.result;
    }
    private void back(int[] nums, List<Integer> temp, boolean[] used){
        if(temp.size()==nums.length){
            this.result.add(new ArrayList<>(temp));
            return ;
        }
        for(int i=0;i<nums.length;i++) {
            if(used[i]||(i>0&&nums[i]==nums[i-1]&&!used[i-1]))
            if (!used[i]){
                temp.add(nums[i]);
            used[i] = true;
            back(nums, temp, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
            }
        }
    }

}
