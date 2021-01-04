package com.leetcode_top;

import com.pojo.TreeNode;

public class 另一个树的子树572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean isSubTree = false;
        return DFS(s, t);
    }

    public boolean valid(TreeNode root, TreeNode t){
        if((root==null&&t!=null)||(t==null&&root!=null)){
            return false;
        }
        if(root==null&&t==null){
            return true;
        }
        if(root.val==t.val) {
            return valid(root.left, t.left)&&valid(root.right, t.right);
        }else{
            return false;
        }
    }

    public boolean DFS(TreeNode s, TreeNode t){
        if(s==null){return false;}
        if(valid(s, t)){
            return true;
        }else{
            return DFS(s.left, t)||DFS(s.right, t);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(1);
        TreeNode t = new TreeNode(1);
        boolean isSubTree = new 另一个树的子树572().isSubtree(node, t);
        System.out.println(isSubTree);
    }
}
