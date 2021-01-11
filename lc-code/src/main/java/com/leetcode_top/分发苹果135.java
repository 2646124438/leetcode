package com.leetcode_top;

public class 分发苹果135 {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        for(int i=0;i<ratings.length;i++){
            if (i > 0&&ratings[i]>ratings[i-1]) {
                left[i] = left[i-1]+1;
            }else{
                left[i] = 1;
            }
        }
        int[] right = new int[ratings.length];
        int ref = 0;
        for(int i=ratings.length-1;i>=0;i--){
            if(i<ratings.length-1&&ratings[i]>ratings[i+1]){
                right[i] = right[i+1]+1;
            }else{
                right[i] = 1;
            }
            ref+=Math.max(left[i], right[i]);
        }
        return ref;
    }

    public static void main(String[] args) {
        int[] ratings = new int[]{1,2,2};
        int total = new 分发苹果135().candy(ratings);
        System.out.println(total);
    }
}
