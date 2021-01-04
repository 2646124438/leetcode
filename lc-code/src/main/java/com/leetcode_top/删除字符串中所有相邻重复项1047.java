package com.leetcode_top;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 删除字符串中所有相邻重复项1047 {
    public String removeDuplicates(String S) {
        Deque<Character> deque = new LinkedList<>();
        for(int i=0;i<S.length();i++){
            Character character = S.charAt(i);
            if(deque.isEmpty()||deque.peekFirst()!=character){
                deque.push(character);
            }else{
                deque.pop();
            }
        }
        String result = "";
        while(!deque.isEmpty()){
            result+=deque.pollLast();
        }
        return result;
    }

    public static void main(String[] args) {
        new 删除字符串中所有相邻重复项1047().removeDuplicates("abbaca");
    }
}
