package main.java.com.leetcode_top;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 无重叠区间435 {
    //找到最少的移除空间，来保证剩下的空间不重叠
//    可以认为区间的终点总是大于它的起点。
//    区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t0, int[] t1) {
                if(t0[1]==t1[1]) return t0[0]-t1[0];
                return t0[1]-t1[1];
            }
        });
        int prev = intervals[0][1];
        int res = 0;
        for(int i=1;i<intervals.length;i++){
            int x = intervals[i][0];
            int y = intervals[i][1];
            if(x<prev){
                res++;
            }else{
                prev = y;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] spaceArr = new int[4][2];
        spaceArr[0] = new int[]{1, 2};
        spaceArr[1] = new int[]{2, 3};
        spaceArr[2] = new int[]{3, 4};
        spaceArr[3] = new int[]{1, 3};
//        [ [1,2], [2,3], [3,4], [1,3] ]
        int res = new 无重叠区间435().eraseOverlapIntervals(spaceArr);
        System.out.println(res);
    }
}
