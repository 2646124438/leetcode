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
        List<Integer> result = new ArrayList<Integer>();
        preOrder(root, temp);
        root = result.right;
    }
    public void preOrder(TreeNode root, TreeNode temp){
        if(root==null) return;
        int val = root.val;
        temp.right = new TreeNode(val);
        temp.left = null;
        temp = temp.right;
        dfs(root.right, temp);
        dfs(root.left, temp);
    }

    public LinkNode reverLinkedNode(LinkNode head){
        LinkNode curr = head;
        LinkNode pre = null;
        while(curr==null){
            LinkNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

}
