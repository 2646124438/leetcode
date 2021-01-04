package com.leetcode_top;

public class 岛屿的个数200 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] used = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(used[i][j]==false&&grid[i][j]=='1'){
                    dfs(grid, i, j, used, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int mindex, int nindex, boolean[][] used, int m, int n){
        if(grid[mindex][nindex]=='0'){
            return;
        }else {
            used[mindex][nindex] = true;
        }
        if(grid[mindex][nindex]=='1'){
            if(mindex<m&&grid[mindex+1][nindex]=='1'){
                dfs(grid, mindex+1, nindex, used, m, n);
            }
            if(nindex<n&&grid[mindex][nindex+1]=='1'){
                dfs(grid, mindex, nindex+1, used, m, n);
            }
        }
    }
}
