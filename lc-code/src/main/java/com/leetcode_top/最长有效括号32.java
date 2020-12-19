package com.leetcode_top;

import java.util.Stack;

public class 最长有效括号32 {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()||s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }
            if(stack.peek()=='('&&s.charAt(i)==')'){
                stack.pop();
                max+=2;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new 最长有效括号32().longestValidParentheses("()(()");
    }
}
