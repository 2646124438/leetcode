package com.leetcode_top;

import java.util.*;

public class 计算器II_227 {

    List<String> operationList = Arrays.asList("+", "-", "*", "/");
    public int calculate(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> operaStack = new LinkedList<>();
        s=s.replaceAll(" ", "");
        for(int i=0;i<s.length();i++){

        }

        return numStack.pop();
    }

    public int getNumber(String s, int j, int number){
        while(j<s.length()&&!operationList.contains(s.substring(j, j+1))){
            number = number*10+Integer.parseInt(s.substring(j, j+1));
            j++;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(new 计算器II_227().calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}
