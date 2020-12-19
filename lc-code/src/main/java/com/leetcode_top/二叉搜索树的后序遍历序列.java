package com.leetcode_top;

public class 二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyHelper(postorder, 0, postorder.length-1);
    }
    public boolean verifyHelper(int[] postorder, int begin ,int end){
        if(begin>end)return true;
        int root = postorder[end];
        int p = begin;
        int m = begin;
        while(postorder[p]<root){ p++;}
        m = p;
        while(postorder[p]>root){p++;}
        return p==end&&verifyHelper(postorder, begin, m-1)&&verifyHelper(postorder, m, end-1);
    }
}
