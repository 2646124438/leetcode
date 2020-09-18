package com.jiangli.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
//        [3,1,3,5,1,1]
//        8
        List<List<Integer>> resultList = combinationSum2(new int[]{4,2,1,4,2,2,1,3}, 6);
        for(List<Integer> item:resultList){
            for(Integer val:item){
                System.out.print(val);;
            }
            System.out.println(' ');
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result_list = new ArrayList<List<Integer>>();
        if(candidates.length==0) return result_list;
        Arrays.sort(candidates);
        back(result_list, target, candidates, 0, 0, new ArrayList<Integer>());
        return result_list;
    }

    public static boolean isMatch(List<Integer> listSrc, List<Integer> listTarget){
        if(listSrc.size()!=listTarget.size()) return false;
        Collections.sort(listSrc);
        Collections.sort(listTarget);
        for(int i=0;i<listSrc.size();i++){
            if(listSrc.get(i)!=listTarget.get(i)){
                return false;
            }
        }
        return true;

    }

    public static void back(List<List<Integer>> result, int target, int[] candidates, int index,
                     int itemSum,List<Integer> itemList){

        if(itemSum==target){
            List<Integer> toAdd = new ArrayList<Integer>();
            for(Integer itemVal:itemList){
                toAdd.add(candidates[itemVal]);
            }
            for(List<Integer> itemResult: result){
                if(isMatch(itemResult, toAdd)){return ;}
            }
            result.add(toAdd);
            return ;
        }

        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(itemSum+candidates[i]<=target&&!itemList.contains(i)){
                itemList.add(i);
                back(result, target, candidates, i+1, itemSum+candidates[i], itemList);
                itemList.remove(itemList.size()-1);
//                itemSum = 0;
//                for(Integer tem:itemList){
//                    itemSum+=candidates[tem];
//                }
            }
        }
    }

}
