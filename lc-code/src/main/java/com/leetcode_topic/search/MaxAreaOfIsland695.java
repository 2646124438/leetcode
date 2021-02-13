package com.leetcode_topic.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland695 {
    public int maxAreaOfIsland(int[][] grid){
        int maxArea = 0;
        int m = grid.length-1;
        int n = 0;
        if(m<0){
            return 0;
        }
        n = grid[0].length-1;

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                boolean[][] status = new boolean[m+1][n+1];
                if(grid[i][j]==1) {
                    maxArea = Math.max(maxArea, getArea(grid, i, j, m, n));
                }
            }
        }
        return maxArea;
    }

    public int getArea(int[][] grid, int im, int jn, int m, int n){
        int area = 0;
        if(im<0||jn<0||im>m||jn>n){
            return 0;
        }
        if(grid[im][jn]==1){
//            status[im][jn] = true;
            grid[im][jn] = 0;
            area=1;
        }else{
            return area;
        }
        area += getArea(grid, im+1, jn, m, n);
        area += getArea(grid, im-1, jn, m, n);
        area += getArea(grid, im, jn+1, m, n);
        area += getArea(grid, im, jn-1, m, n);
        return area;
    }

    public int geteaByBFS(int[][] grid){
        int maxArea = 0;
        int m = grid.length-1;
        int n = 0;
        if(m<0){
            return 0;
        }
        n = grid[0].length-1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                Queue<Integer> queuei = new LinkedList<>();
                Queue<Integer> queuej = new LinkedList<>();
                queuei.add(i);
                queuej.add(j);
                int area = 0;
                while(!queuei.isEmpty()&&!queuej.isEmpty()){
                    int pollI = queuei.poll();
                    int pollJ = queuej.poll();
                    if(pollI<0||pollI>m||pollJ<0||pollJ>n||grid[pollI][pollJ] == 0){
                        continue;
                    }
                    area+=1;
                    grid[pollI][pollJ] = 0;
                    queuei.add(pollI-1);
                    queuej.add(pollJ);
                    queuei.add(pollI+1);
                    queuej.add(pollJ);
                    queuei.add(pollI);
                    queuej.add(pollJ-1);
                    queuei.add(pollI);
                    queuej.add(pollJ+1);

                }
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid = new int[4][5];
        grid[0] = new int[]{1,1,0,0,0};
        grid[1] = new int[]{1,1,0,0,0};
        grid[2] = new int[]{0,0,0,1,1};
        grid[3] = new int[]{0,0,0,1,1};
//        int area = new MaxAreaOfIsland695().maxAreaOfIsland(grid);
        int area = new MaxAreaOfIsland695().geteaByBFS(grid);
        System.out.println(area);
    }
}
