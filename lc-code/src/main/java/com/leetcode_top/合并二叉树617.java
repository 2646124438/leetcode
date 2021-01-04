package com.leetcode_top;

import com.pojo.TreeNode;

public class 合并二叉树617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode node = null;
        if(t1==null&&t2==null){
            return null;
        }
        if(t1!=null&&t2!=null) {
            int mergeVal = t1.val + t2.val;
            node = new TreeNode(mergeVal);
        }else{
            node = t1==null?t2:t1;
        }
        node.left = mergeTrees(t1==null?null:t1.left, t2==null?null:t2.left);
        node.right = mergeTrees(t1==null?null:t1.right, t2==null?null:t2.right);
        return node;
    }

    public TreeNode buildTree(Integer[] nums, Integer index){
        TreeNode tn = null;
        if(index<nums.length){
            tn = nums[index]==null?null:new TreeNode(nums[index]);
            if(tn==null){
                return null;
            }
            tn.left = buildTree(nums, 2*index+1);
            tn.right = buildTree(nums, 2*index+2);
        }
        return tn;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        t2.right.right = new TreeNode(3);
        TreeNode tree = new 合并二叉树617().mergeTrees(t1, t2);
        System.out.println(tree);
    }
}
