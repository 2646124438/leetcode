package com.leetcode_top;

import java.util.ArrayList;
import java.util.List;

public class 括号生成22 {
    List<String> result  = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        if(n==0){
            return result;
        }
        //相当于有3个左括号和3个右括号，分别取了进行组合。当出现左括号比右括号剩余数目还多的时候，就说明这种情况一定不行
        combine("(", n-1, n);
        System.out.println(result);
        return result;
    }

    public void combine(String item , int leftNum, int rightNum){
        if(leftNum>rightNum||leftNum<0||rightNum<0){
            return;
        }
        if(leftNum==0&&rightNum==0){
            result.add(item);
            return;
        }
        for(int i=0;i<2;i++){

            if(i==0){
                item+='(';
                combine(item, leftNum-1, rightNum);
                item = item.substring(0, item.length()-1);
            }else if(i==1){
                item+=')';
                combine(item, leftNum, rightNum-1);
                item = item.substring(0, item.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        new 括号生成22().generateParenthesis(3);
    }

}
