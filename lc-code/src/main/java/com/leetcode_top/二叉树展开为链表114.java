package com.leetcode_top;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 目前尚未解决
 */
public class 二叉树展开为链表114 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public class LinkNode{
        int val;
        LinkNode next;
    }
    TreeNode result;
    public void flatten(TreeNode root) {
        List<TreeNode> inOrderList= new ArrayList<>();
        preorder(root, inOrderList);
        for(int i=1;i<inOrderList.size();i++){
            TreeNode pre = inOrderList.get(i-1);
            TreeNode curr = inOrderList.get(i);
            pre.left = null;
            pre.right = curr;
        }
    }

    public void preorder(TreeNode root, List<TreeNode> preList){
        if(root==null) return ;
        preList.add(root);
        preorder(root.left, preList);

        preorder(root.right, preList);
    }

}
