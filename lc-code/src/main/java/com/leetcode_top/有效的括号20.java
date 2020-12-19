package com.leetcode_top;

import java.util.Stack;

public class 有效的括号20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            Character charAtI = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                Character top = stack.peek();
                if((top=='('&&charAtI==')')||(top=='['&&charAtI==']')||(top=='{'&&charAtI=='}')){
                    stack.pop();
                }else{
                    stack.push(charAtI);
                }
            }
        }
        return stack.isEmpty();
    }
}
