package com.leetcode_top;

import java.util.Arrays;
import java.util.List;

public class 单词搜索79_2 {
    private boolean isMatch = false;
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        int index = 0;
        boolean[][] used = new boolean[m][n];
        boolean result = false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
//                char targetChar = word.charAt(index);
                if(check(i, j, board, used, 0, word)){
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }

    public boolean check(int i, int j, char[][] board, boolean[][] used, int index, String word){
        if(board[i][j]!=word.charAt(index)){
            return false;
        }else if(index==word.length()-1){
            return true;
        }
        boolean result =false;
        used[i][j] = true;
        List<List<Integer>> directionList = Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,0),
                Arrays.asList(0,-1),
                Arrays.asList(-1,0)
        );
        for(List<Integer> dirList:directionList){
            int iDir = dirList.get(0);
            int jDir = dirList.get(1);
            if(i+iDir>=0&&i+iDir<m&&j+jDir>=0&&j+jDir<n
                    &&!used[i+iDir][j+jDir]){
                boolean flag = check(i+iDir, j+jDir, board, used, index+1, word);
                if(flag){
                    result = true;
                    break;
                }
            }
        }
        used[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][4];
        board[0] = new char[]{'a', 'b', 'c', 'e'};
        board[1] = new char[]{'s', 'f', 'c', 's'};
        board[2] = new char[]{'a', 'd', 'e', 'e'};
        new 单词搜索79_2().exist(board, "abcced");
    }
}
