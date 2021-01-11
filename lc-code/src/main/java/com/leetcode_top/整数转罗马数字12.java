package com.leetcode_top;

public class 整数转罗马数字12 {
    public String[] index2Str = new String[]{"I", "X", "C", "M"};
    public String[] index2StrHalf = new String[]{"V", "L", "D"};
    public String intToRoman(int num) {
        int numTemp = num;
        int iNum=0;
        String result = "";
        while(numTemp>0){
            int temp = numTemp%10;
            numTemp = numTemp/10;
            String numStr = getNumStr(temp, iNum);
            iNum = iNum + 1;
            result = numStr + result;
        }
        return result;
    }

    public String getNumStr(int temp, int index){
        if(temp==5){
            return index2StrHalf[index];
        }else if(temp==4){
            return index2Str[index]+index2StrHalf[index];
        }else if(temp<4){
            StringBuilder result = new StringBuilder();
            for(int i=0;i<temp;i++){
                result.append(index2Str[index]);
            }
//            result.append(index2Str[index]);
            return result.toString();
        }else if(temp==9){
            return index2Str[index]+index2Str[index+1];
        }else{
            StringBuilder result = new StringBuilder();
            result.append(index2StrHalf[index]);
            for(int i=0;i<temp-5;i++){
                result.append(index2Str[index]);
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        String result = new 整数转罗马数字12().intToRoman(40);
        System.out.println(result);
    }
}
