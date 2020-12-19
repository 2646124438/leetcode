package com.leetcode_top;


import com.pojo.TreeNode;

public class 对称二叉树101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        return isSymmetricHelper(root.left, root.right);
    }
    public boolean isSymmetricHelper(TreeNode node1, TreeNode node2){
        if((node1==null&&node2==null)||(node1!=null&&node2!=null&&node1.val==node2.val)){
            return isSymmetricHelper(node1.left, node2.right)&&
                    isSymmetricHelper(node1.right, node2.left);
        }else{
            return false;
        }
    }
}
