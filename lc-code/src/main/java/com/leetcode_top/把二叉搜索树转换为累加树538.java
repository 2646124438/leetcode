package com.leetcode_top;

import com.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 把二叉搜索树转换为累加树538 {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {

        if(root!=null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        new 把二叉搜索树转换为累加树538().convertBST(root);
    }
}
