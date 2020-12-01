package com.jiangli.binary_tree;

//二叉树直径
public class BinaryTreeRadius {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    int maxPath=0;
    public int diameterOfBinaryTree(TreeNode root) {
        preorder(root);
        return maxPath;
    }

    public void preorder(TreeNode root){
        if(root==null) return;
        maxLen(root);
        preorder(root.left);
        maxLen(root.left);
        preorder(root.right);
        maxLen(root.right);
    }

    public void maxLen(TreeNode node){
        if(node==null) return ;
//        int maxnodePath = 1+maxDepth(node.left)+maxDepth(node.right);
        int leftMaxNode = 1 + maxDepth(node.left);
        int rightMaxNode = 1 + maxDepth(node.right);
        int maxnodePath = leftMaxNode+rightMaxNode-2;
        if(maxnodePath>maxPath){
            maxPath = maxnodePath;
        }
    }

    public int maxDepth(TreeNode node){
        if(node==null) return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
