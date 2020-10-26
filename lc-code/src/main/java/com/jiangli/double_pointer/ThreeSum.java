package main.java.com.jiangli.double_pointer;

import main.java.com.jiangli.linked_node.ListNode;

import java.util.*;

public class ThreeSum {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum2(int[] nums){
        int len = nums.length;
        Arrays.sort(nums);
        int left, right = 0;
        for(int i=0;i<len;i++){
            if(nums[i]>0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
//            item.add(nums[i]);
            for(left=i+1,right=len-1;left<right;){
                int numSum = nums[i]+nums[left]+nums[right];
                if(numSum==0){
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    this.result.add(item);
                    left++;
                    right--;
                }else if(numSum>0){
                    right = right-1;
                }else if(numSum<0){
                    left = left+1;
                }
            }
        }
        return this.result;
    }

    //排列组合方法会超时
    List<List<Integer>> result2 = new ArrayList<>();
    List<Integer> numList = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums){
        int word_num = 3;
        for(Integer i:nums){
            numList.add(i);
        }
//        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        permutation(0, nums, word_num, item);
        return this.result;
    }

    public void permutation(int pos , int[] nums, int word_num, List<Integer> item){
        if(item.size()==word_num-1){
            int itemResult = item.get(0)+item.get(1);
//            item.stream().forEach(i->{itemResult=itemResult+i});

            if(numList.contains(-1*itemResult)){
                List<Integer> itemList = new ArrayList<>();
                item.stream().forEach(i->itemList.add(i));
                itemList.add(-1*itemResult);
                Collections.sort(itemList);
                if(!this.result.contains(itemList)) {
                    this.result.add(itemList);
                }
            }
            return;
        }
        for(int i=pos;i<nums.length;i++){
            item.add(nums[i]);
            numList.remove(numList.indexOf(nums[i]));
            permutation(i+1, nums, word_num, item);
            numList.add(item.get(item.size()-1));
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        new ThreeSum().threeSum2(nums);
    }
}
