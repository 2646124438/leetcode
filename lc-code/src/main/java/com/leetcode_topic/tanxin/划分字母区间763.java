package main.java.com.leetcode_topic.tanxin;

import java.util.ArrayList;
import java.util.List;

public class 划分字母区间763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<S.length();i++){
            int lastIndex = S.lastIndexOf(S.substring(i, i+1));
            int len = 1;
            for(int j=i+1;j<=lastIndex;j++){
                lastIndex = Math.max(lastIndex, S.lastIndexOf(S.substring(j, j+1)));
                len++;
            }
            result.add(len);
            i = lastIndex;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> splitIndex = new 划分字母区间763().partitionLabels(s);
        splitIndex.stream().forEach(i->{
            System.out.println(i);
        });
        System.out.println("-------------");
    }
}
