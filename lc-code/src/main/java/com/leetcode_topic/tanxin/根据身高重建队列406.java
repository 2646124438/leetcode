package main.java.com.leetcode_topic.tanxin;

import java.util.Arrays;
import java.util.Comparator;

public class 根据身高重建队列406 {
//    假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
//    每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
//    请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
//    其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。

    public int[][] reconstructQueue(int[][] people) {
        int[][] queue = new int[people.length][people[0].length];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] t0, int[] t1){
                if(t0[1]==t1[1]) return t0[0]-t1[0];
                return t0[1]-t1[1];
            }
        });
        for(int i=0;i<people.length;i++){
            int[] peopleItem = people[i];
            int h0 = peopleItem[0];
            int h1 = peopleItem[1];
            int k = h0;
            for(int j=i+1;j<people.length;j++){
                int hj0 = people[j][0];
                int hj1 = people[j][1];
                if(hj1!=h1){
                    break;
                }
                if(k>hj0){
                    int[] temp = new int[]{hj0, hj1};
                    people[j] = people[i];
                    people[i] = temp;
                }
            }
        }
        return people;
    }

    public static void main(String[] args) {
//        [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        int[][] people = new int[6][2];
        people[0] = new int[]{7,0};
        people[1] = new int[]{4,4};
        people[2] = new int[]{7,1};
        people[3] = new int[]{5,0};
        people[4] = new int[]{6,1};
        people[5] = new int[]{5,2};
        new 根据身高重建队列406().reconstructQueue(people);
    }
}
