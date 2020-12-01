package com.jiangli.back_track;

public class SplitIntoKGroup {
    public boolean cand(int[] nums, int k){
        if(k==0)return false;
        int total = 0;
        int maxNum = 0;
        for(int i=0;i<nums.length;i++){
            total += nums[i];
            if(nums[i]>maxNum){
                maxNum = nums[i];
            }
        }
        if(total%k!=0) return false;
        int targetSum = total/k;
        if(maxNum>targetSum){
            return false;
        }
        boolean[] used = new boolean[nums.length];
        return backtracking(nums, k, targetSum, 0, 0, used);
    }

    private boolean backtracking(int[] nums, int k, int targetSum, int cur, int start, boolean[] used){
        //返回条件
        if(k==0) return true;
        if (cur == targetSum) {
            //构建下个集合
            return backtracking(nums, k-1, targetSum, 0, 0, used);
        }
        for(int i=start; i<nums.length;i++){
            if(!used[i]&&cur+nums[i]<=targetSum){
                used[i]=true;
                if(backtracking(nums, k, targetSum, cur+nums[i], i+1, used))
                    return true;
                used[i] = false;
            }
        }
        return false;
    }
}
