package com.leetcode_top;

public class 单词搜索79 {
    private boolean match;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char firstChar = word.charAt(0);
                if(board[i][j] == firstChar){
                    boolean[][] used = new boolean[m][n];
                    dfs(i, j, board, used, 1, word);
                }
            }
        }
        return this.match;
    }

    public void dfs(int i, int j ,char[][] board, boolean[][] used, int index, String word){
        if(index==word.length()-1){
            this.match = true;
            return ;
        }
        for(int charIdx = index; charIdx<word.length();charIdx++){

        }
    }

    public boolean charMatch(int i,int j, char[][] board, char target, int m, int n){
        char topChar = i>0?board[i-1][j]:' ';
        char downChar = i+1<m?board[i+1][j]:' ';
        char leftChar = j>0?board[i][j-1]:' ';
        char rightChar = j+1<n?board[i][j+1]:' ';
        if()
    }
}

