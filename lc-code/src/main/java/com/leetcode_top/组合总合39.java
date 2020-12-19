package com.leetcode_top;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class 组合总合39 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        permu(candidates, target, new ArrayList<Integer>(), 0);
        return result;
    }

    public void dfs(int[] candidates, int begin, int target, List<Integer> temp){
        if(target<0){
            return;
        }
        if(target==0){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=begin;i<candidates.length;i++){
            temp.add(candidates[i]);
            dfs(candidates, begin, target-candidates[i], temp);
            temp.remove(temp.size()-1);
        }
    }

    public void permu(int[] candidates, int target, List<Integer> temp, int sumItem){
        if(sumItem>target){
            return;
        }
        if(sumItem==target){

            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=0;i<candidates.length;i++){
            if((target-sumItem)%candidates[i]==0){
                int count = (target-sumItem)/candidates[i];
                sumItem += candidates[i]*count;
                for(int num = 0;num<count;num++) {
                    temp.add(candidates[i]);
                }
                permu(candidates, target,temp, sumItem);
                sumItem -= candidates[i]*count;
                for(int num =0; num<count;num++){
                    temp.remove(temp.size()-1);
                }
            }else {
                sumItem += candidates[i];
                temp.add(candidates[i]);
                permu(candidates, target, temp, sumItem);
                temp.remove(temp.size() - 1);
                sumItem -= candidates[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        new 组合总合39().combinationSum(arr, 7);
    }


}
