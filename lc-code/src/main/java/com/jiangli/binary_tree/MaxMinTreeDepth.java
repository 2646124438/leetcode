package com.jiangli.binary_tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

import java.lang.Math;
//二叉树 最大最小深度
// leetcode #104 二叉树的最大深度
//剑指 Offer 55 - I 二叉树的深度
//#111 二叉树的最小深度
//#102 二叉树的层序遍历
public class MaxMinTreeDepth {
    public class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public int maxDepthDFS(TreeNode root){
        if(root==null) return 1;
        if(root.left==null) return 1+maxDepthDFS(root.right);
        if(root.right==null) return 1+maxDepthDFS(root.left);
        return 1+Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
    }
    public int maxDepthBFS(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int depth = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            depth+=1;
            for(int i=0;i<levelSize;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }
    public int minDepthDFS(TreeNode root){
        if(root==null) return 0;
        return 1+Math.min(minDepthDFS(root.left), minDepthDFS(root.right));
    }
    public int minDepthBFS(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue=  new LinkedList<TreeNode>();
        queue.add(root);
        int minDepth = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            minDepth +=1;
            for(int i=0;i<levelSize;i++){
                TreeNode node = queue.poll();
                if(node==null){
                    continue;
                }
                if(node.left==null&&node.right==null){
                    return minDepth;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return minDepth;
    }
}
