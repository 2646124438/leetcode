package com.leetcode_top;


import com.pojo.TreeNode;

public class 验证二叉搜索树98 {
    boolean isValid = true;
    int num;
    public boolean isValidBST(TreeNode root) {
        this.num = Integer.MIN_VALUE;
        isValidHelper(root);
        return isValid;
    }
    public void isValidHelper(TreeNode root){
        if(root==null) return;
        isValidHelper(root.left);
        if(root.val>num){
            num = root.val;
        }else{
            this.isValid = false;
        }
        isValidHelper(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        node.left = left;
        new 验证二叉搜索树98().isValidBST(node);
    }
}
