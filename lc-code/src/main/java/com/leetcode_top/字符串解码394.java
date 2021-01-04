package com.leetcode_top;

import java.util.Stack;

public class 字符串解码394 {
//    String result = "";

    public String decodeString(String s){
        int num = 0;
        String result = "";
        for(int i=0;i<s.length();i++){
            Character character = s.charAt(i);
            if(character>='0'&&character<='9'){
                num = num*10+character-'0';
            }else if(character=='['){
                Stack<Character> stack = new Stack<>();
                stack.push(character);
                int j=i;
                while(!stack.isEmpty()){
                    j++;
                    Character character1 = s.charAt(j);
                    if(character1=='['){
                        stack.push(character1);
                    }else if(character1==']'){
                        stack.pop();
                    }
                }
                String tempItem = s.substring(i+1, j);
                for(int k = 0;k<num;k++){
                    result+=decodeString(tempItem);
                }
                i = j;
                num=0;
            }else{
                result+=character;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "3[a]2[bc]";
        input = "10[a]";
        String result = new 字符串解码394().decodeString(input);
        System.out.println(result);
    }
}
