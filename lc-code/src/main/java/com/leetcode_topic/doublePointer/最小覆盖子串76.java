package com.leetcode_topic.doublePointer;

import sun.text.normalizer.UCharacter;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串76 {
    // 1. 左右指针，都指向0，开始. for i-s.length
    // 2. 遍历，如果r逐个移动，将指向的字符加入map中，或者更改相应的value
    // 3.     在2步基础之上，每个字符加入后都会判断，是否l-r区间包含所有t的字符
    // 4.     当3步满足，就是r-l包含所有String t的字符。想办法移动l.
    // 5.     当l移动到下一个t的字符位置，并且已经空出一个charTMap，用来找下个字符进行填充

    // 更新后的思路：
    // 1. 左右指针同向
    // 2. tMap存储String t的内容,先进行初始化
    // 3. 然后开始循环，从r开始。
    // 4.    逐个判断r指向的s.charAt(r)是否在tMap的key中，如果存在就put到sMap中
    // 5.    此时判断tMap中的各个字符是否在sMap中都一一对应，并且sMpa中的值不小tMap中
    // 6.    一旦check为true，说明smap中的字符串满足要求，此时考虑移动l，每次移动前都会更新判断是否此时l-r是最短字符串，
//              因为此时是移除l，所以如果s.charAt(l)在tMap中则会减去sMap中对应值，说明将其移动出。该循环直至check失败
    Map<Character, Integer> tMap = new HashMap<>();
    Map<Character, Integer> sMap = new HashMap<>();
    public String minWindow(String s, String t) {
        int r = -1;
        int l = 0;
//        Map<Character, Integer> tMap = new HashMap<>();
//        Map<Character, Integer> sMap = new HashMap<>();
        for(int i=0;i<t.length();i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        int len = Integer.MAX_VALUE;
        int anL = -1;
        int anR = -1;
        String result = "";
        while(r<s.length()){
            r++;
            if(r<s.length()&&tMap.containsKey(s.charAt(r))){
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0)+1);
            }
            while(check()&&l<=r){
                if(r-l<len){
                    len = r-l;
                    anL = l;
                    anR = l+len+1;
                    result = s.substring(anL, anR);
                }
                if(tMap.containsKey(s.charAt(l))){
                    sMap.put(s.charAt(l), sMap.getOrDefault(s.charAt(l), 0)-1);
                }
                l++;
            }
        }
        return result;
    }

    public boolean check(){
        for(Map.Entry<Character, Integer> entry:tMap.entrySet()){
            Character key  = entry.getKey();
            Integer value = entry.getValue();
            if(sMap.getOrDefault(key, 0)<value){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = new 最小覆盖子串76().minWindow(s, t);
//        String result = new 最小覆盖子串76().minWindow("aa", "aa");
        System.out.println(result);
    }
}
