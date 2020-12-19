package com.leetcode_top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合17 {
    List<String> result = new ArrayList<String>();
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits){
        back(digits, 0, "");
        return this.result;
    }

    public void back(String digits, int charIdx, String temp){
        if(temp.length()==digits.length()){
            result.add(temp);
            return;
        }
        String charList = phoneMap.get(digits.charAt(charIdx));
        for(int i=0;i<charList.length();i++){
            if(!temp.contains(charList.substring(i, i+1))){
                temp+=charList.substring(i, i+1);
                back(digits, charIdx+1, temp);
                temp = temp.substring(0, temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        new 电话号码的字母组合17().letterCombinations("23");
    }
}
