package com.leetcode_topic.sort;

import java.util.HashMap;
import java.util.Map;

public class SortByCharacFreq451 {
    public String frequencySort(String s) {
        Map<Character, Integer> characFreq = new HashMap<>();
        for(int i=0;i<s.length();i++){
            characFreq.put(s.charAt(i), characFreq.getOrDefault(s.charAt(i), 0)+1);
        }
        Character[] charArr = new Character[characFreq.keySet().size()];
        int[] countArr = new int[characFreq.keySet().size()];
        int i=0;
        for(Map.Entry<Character, Integer> entry:characFreq.entrySet()){
            charArr[i] = entry.getKey();
            countArr[i] = entry.getValue();
            i++;
        }
        sort(countArr, charArr, 0, countArr.length-1);
        StringBuilder sb = new StringBuilder();
        for(int id = 0;id<charArr.length;id++){
            Character character = charArr[id];
            for(int item=0;item<countArr[id];item++){
                sb.append(character);
            }
        }
        return sb.toString();
   }
    public void sort(int[] nums, Character[] charArr, int left, int right){
        if(left>=right){
            return ;
        }
        int start = left;
        int end = right;
        int currKey = nums[left];
        Character currChar = charArr[left];
        while(left<right){
            while(left<right&&currKey>=nums[right]){
                right--;
            }
            nums[left] = nums[right];
            charArr[left] = charArr[right];
            while(left<right&&currKey<=nums[left]){
                left++;
            }
            nums[right] = nums[left];
            charArr[right]=charArr[left];
        }
        nums[left] = currKey;
        charArr[left] = currChar;
        sort(nums, charArr, start, left-1);
        sort(nums, charArr, left+1, end);
    }

    public static void main(String[] args) {
        String input = "tree";
//        input = "cccaaa";
        String result = new SortByCharacFreq451().frequencySort(input);
        System.out.println(result);
    }
}
