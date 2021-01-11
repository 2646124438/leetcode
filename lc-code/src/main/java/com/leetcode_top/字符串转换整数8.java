package com.leetcode_top;

import java.util.HashMap;
import java.util.Map;

public class 字符串转换整数8 {
    private int sign = 1;
    private Character firstChar = null;

    // 利用状态机解决。分析每个字符和对应状态的转换。
    //              ' '       +/-    number    other
    //  start      start    signed   in_num     end
    //  signed      end      end     in_num     end
    //  in_num      end      end     in_num     end
    //  end         end      end     in_num     end
    public int myAtoi(String s) {
        String state = "start";
        Map<String, String[]> stateMap = new HashMap<String, String[]>(){
            {
                put("start", new String[]{"start", "signed", "in_num", "end"});
                put("signed", new String[]{"end", "end", "in_num", "end"});
                put("in_num", new String[]{"end", "end", "in_num", "end"});
                put("end", new String[]{"end", "end", "in_num", "end"});
            }
        };
        long num = 0;
        int signed = 1;
        for(int i=0;i<s.length();i++){
            Character character = s.charAt(i);
            int index = getIndex(character);
            state = stateMap.get(state)[index];
            if(state.equals("start")){
                continue;
            }else if(state.equals("end")){
                break;
            }else if(state.equals("signed")){
                signed = character=='-'?-1:1;
                continue;
            }else{
                num = num*10+character-'0';
                if(num*signed>=Integer.MAX_VALUE){
                    num = Integer.MAX_VALUE;
                    return (int)num;
                }else if(num*signed<=Integer.MIN_VALUE){
                    num = Integer.MIN_VALUE;
                    return (int) num;
                }
            }
        }
        return signed*(int)num;
    }

    public int getIndex(Character character){
        if(character==' '){
            return 0;
        }else if(character=='+'||character=='-'){
            return 1;
        }else if(Character.isDigit(character)){
            return 2;
        }else {
            return 3;
        }
    }

    public static void main(String[] args) {
       int result = new 字符串转换整数8().myAtoi("2147483648");
        System.out.println(result);
    }
}
