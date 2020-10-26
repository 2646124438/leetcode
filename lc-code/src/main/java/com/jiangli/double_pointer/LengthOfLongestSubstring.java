package main.java.com.jiangli.double_pointer;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<2) return s.length();
        int p = 0;
        int q = 1;
        int maxlen = -1;
        while(q<=s.length()){
            String subStr = s.substring(p,q);
            String charStr = s.charAt(q)+"";
            if(subStr.contains(charStr)||q==s.length()){
                if(q-p>maxlen){
                    maxlen = q-p;
                }
                p = p+1+subStr.indexOf(charStr);
            }else{
                if(q-p>maxlen){
                    maxlen = q-p;
                }
                q++;
            }
        }
        return maxlen<0?s.length():maxlen;
    }

    public int lengthOfLongestSubstring2(String s){
        if(s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }

//    public static void main(String[] args) {
//        int result = new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb");
//        System.out.println(result);
//    }

}
