package com.jiangli.back_track;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class KuoHaoMatch {
    // 22
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n==0) return result;

        gen(result, "(", 2, 3);
        return result;
    }

    public void gen(List<String> result, String content, int left, int right){
        if(left==0&&right==0){
            result.add(content);
        }

        if(left>0) {
            gen(result, content + "(", left - 1, right);
        }else if(right>0&&left<right){
            gen(result, content+")", left, right-1);
        }
    }

}

