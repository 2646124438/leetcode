package com.jiangli.binary_tree;

//恢复二叉树，leetcode 99
public class RecoverBST {
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        TreeNode(int val){this.val = val;}
    }
    /*
    * 思路： 二叉树中序遍历，都是递增的。所以直接中序遍历后，找到两个不符合要求的节点，交换即可
    * */
    private TreeNode prev = null;
    private TreeNode x = null;
    private TreeNode y = null;
    public TreeNode recoverTree(TreeNode root){
        traverseChild(root);
        if(x!=null&&y!=null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
            return root;
        }
        return root;
    }

    public void traverseChild(TreeNode root){
        if(root==null) return;
        traverseChild(root.left);
        if(prev==null){
            prev = root;
        }else{
            if(root.val<prev.val){
                y = root;
                if(x==null){
                    x=prev;
                }
            }
            prev = root;
        }
        traverseChild(root.right);

    }

}
