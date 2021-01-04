package com.leetcode_top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 单词搜索79 {

    private boolean match;
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char firstChar = word.charAt(0);
                if(board[i][j] == firstChar){
                    boolean[][] used = new boolean[m][n];
                    used[i][j] = true;
                    dfs(i, j, board, used, 1, word);
                    used[i][j] = false;
                }
            }
        }
        return this.match;
    }

    public void dfs(int i, int j ,char[][] board, boolean[][] used, int index, String word){
        if(index==word.length()){
            this.match = true;
            return ;
        }
        for(int charIdx = index; charIdx<word.length();charIdx++){
            char target = word.charAt(charIdx);
            if(topMatch(i, j, board, used, target)){
                used[i-1][j] = true;
                dfs(i-1, j, board, used, index+1, word);
                used[i-1][j] = false;
            }
            if(!this.match&&downMatch(i, j, board, used, target)){
                used[i+1][j] = true;
                dfs(i+1, j, board, used, index+1, word);
                used[i+1][j] = false;
            }
            if(!this.match&&leftMatch(i, j, board, used, target)){
                used[i][j-1] = true;
                dfs(i, j-1, board, used, index+1, word);
                used[i][j-1] = false;
            }
            if(!this.match&&rightMatch(i, j, board, used, target)){
                used[i][j+1] = true;
                dfs(i, j+1, board, used, index+1, word);
                used[i][j+1] = false;
            }
            if(!this.match){
                break;
            }
        }
    }

    public boolean topMatch(int i, int j, char[][] board, boolean[][] used, char target){
        char topChar = i>0&&!used[i-1][j]?board[i-1][j]:' ';
        if(topChar==target){
            return true;
        }
        return false;
    }
    public boolean downMatch(int i, int j, char[][] board, boolean[][] used, char target){
        char downChar = i+1<this.m&&!used[i+1][j]?board[i+1][j]:' ';
        if(downChar==target){
            return true;
        }
        return false;
    }
    public boolean leftMatch(int i, int j, char[][] board, boolean[][] used, char target){
        char leftChar = j>0&&!used[i][j-1]?board[i][j-1]:' ';
        if(leftChar==target){
            return true;
        }
        return false;
    }
    public boolean rightMatch(int i, int j, char[][] board, boolean[][] used, char target){
        char rightChar = j+1<this.n&&!used[i][j+1]?board[i][j+1]:' ';
        if(rightChar==target){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[4][4];
        board[0] = new char[]{'A', 'A', 'A', 'A'};
        board[1] = new char[]{'A', 'A', 'A', 'A'};
        board[2] = new char[]{'A', 'A', 'A', 'A'};
        board[3] = new char[]{'A', 'A', 'A', 'A'};
//        board[4] = new char[]{'A', 'L', 'A', 'N', 'S', 'A', 'P'};
//        board[5] = new char[]{'O', 'O', 'G', 'O', 'T', 'P', 'N'};
//        board[6] = new char[]{'H', 'P', 'O', 'L', 'A', 'N', 'O'};
//        ["F","Y","C","E","N","R","D"],["K","L","N","F","I","N","U"],["A","A","A","R","A","H","R"],["N","D","K","L","P","N","E"],
//        ["A","L","A","N","S","A","P"],["O","O","G","O","T","P","N"],["H","P","O","L","A","N","O"]]
        new 单词搜索79().exist(board, "aaaaaaaaaaaa");
    }
}

