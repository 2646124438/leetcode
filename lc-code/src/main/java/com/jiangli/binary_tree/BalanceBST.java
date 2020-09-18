package com.jiangli.binary_tree;

//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//        本题中，一棵高度平衡二叉树定义为：
//
//        一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
public class BalanceBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // 思路：左右子树的高度差小于等于1,并且左右子树都是平衡二叉树
    public boolean isBalanced(TreeNode root) {
        return Math.abs(maxDepthDFS(root.left)-maxDepthDFS(root.right))<=1
                &&isBalanced(root.left)&&isBalanced(root.right)?true:false;
    }

    public int maxDepthDFS(TreeNode root){
        if(root==null) return 0;
        if(root.left==null) return 1+maxDepthDFS(root.right);
        if(root.right==null) return 1+maxDepthDFS(root.left);
        return 1+Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
    }

    public int minDepthDFS(TreeNode root){
        if(root==null)return 0;
        return 1+Math.min(maxDepthDFS(root.left), maxDepthDFS(root.right));
    }


}
