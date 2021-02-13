package com.leetcode_topic.search;

import java.util.ArrayList;
import java.util.List;

public class CircleNum547 {
    boolean[] usedStatus;
    public int findCircleNum(int[][] isConnected) {
        usedStatus = new boolean[isConnected.length];
        int cirNum = 0;
        for(int i=0;i<isConnected.length;i++){
            if(usedStatus[i]){
                continue;
            }
            List<Integer> used = new ArrayList<>();
            used.add(i);
            usedStatus[i] = true;
            getNextConnect(isConnected, i, used);
            getPreConnect(isConnected, i, used);
            cirNum+=1;
        }
        return cirNum;
    }

    public void getNextConnect(int[][] isConneced, int i, List<Integer> used){
        for(int item=i;item<isConneced.length;item++){
            if(isConneced[i][item]==1&&i!=item){
                used.add(item);
                usedStatus[item] = true;
                getNextConnect(isConneced, item, used);
                getPreConnect(isConneced, item, used);
            }
        }
    }
    public void getPreConnect(int[][] isConnect, int i, List<Integer> used){
        for(int item = i;item<isConnect.length;item++){
            if(isConnect[item][i] ==1&&i!=item){
                used.add(item);
                usedStatus[item] =true;
                getNextConnect(isConnect, item, used);
                getPreConnect(isConnect, item, used);
            }
        }
    }

    public static void main(String[] args) {
        int[][] cirArr = new int[3][3];
        cirArr[0] = new int[]{1,1,0};
        cirArr[1] = new int[]{1,1,0};
        cirArr[2] = new int[]{0,0,1};
        int cirNum = new CircleNum547().findCircleNum(cirArr);
        System.out.println(cirNum);

        int[][] cirArr1 = new int[4][4];
        cirArr1[0] = new int[]{1,0,0,1};
        cirArr1[1] = new int[]{0,1,1,0};
        cirArr1[2] = new int[]{0,1,1,1};
        cirArr1[3] = new int[]{1,0,1,1,};
        
    }
}
