package com.jiangli.binary_tree;
//    根据一棵树的前序遍历与中序遍历构造二叉树。
//        注意:
//        你可以假设树中没有重复的元素。
//        例如，给出
//        前序遍历 preorder = [3,9,20,15,7]
//        中序遍历 inorder = [9,3,15,20,7]
//        返回如下的二叉树：
//        3
//        / \
//        9  20
//        /  \
//        15   7

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Leetcode105 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){return null;}
        return  buildTreeHelper(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int p_start, int p_end, int i_start ,int i_end){
        if(p_start==p_end){
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int left_num = 0;
        int root_index = -1;
        for(int i=i_start;i<i_end;i++){
            if(inorder[i]==root_val){
                root_index = i;
                break;
            }
        }
        left_num = root_index-i_start;

        root.left = buildTreeHelper(preorder, inorder, p_start+1, p_start+left_num+1, i_start, root_index);
        root.right = buildTreeHelper(preorder, inorder, p_start+1+left_num, p_end, root_index+1, i_end);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder ,inorder);
        System.out.println(root.val);
    }
}
