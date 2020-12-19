package com.leetcode_top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间56 {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,
                new Comparator<int[]>() {
                    public int compare(int[] o1, int[] o2) {
                        return o1[0]-o2[0];
                    }
                });

        boolean[] used = new boolean[intervals.length];
        int[][] resultArr = new int[intervals.length][];
        List<int[]> resultArrList = new ArrayList<int[]>();
//        int pos = 0;
        for(int i=0;i<intervals.length;i++){
            if(used[i]) continue;
            int[] arrI = intervals[i];
            int beginI = arrI[0];
            int endI = arrI[1];
            for(int j=i+1;j<intervals.length;j++){
                if(used[j]) continue;
                int[] arrJ = intervals[j];
                int beginJ = arrJ[0];
                int endJ = arrJ[1];
                if((endI>=beginJ&&endI<=endJ)||(beginI>=beginJ&&beginI<=endJ)||(beginI<=beginJ&&endI>=endJ)){
                    used[j] = true;
                    endI = endI>endJ?endI:endJ;
                    beginI = beginI>beginJ?beginJ:beginI;
                }
            }
            int[] newItemArr = new int[2];
            newItemArr[0] = beginI;
            newItemArr[1] = endI;
            resultArrList.add(newItemArr);
        }

        return resultArrList.toArray(new int[resultArrList.size()][]);
    }
}
