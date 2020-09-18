package com.jiangli.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraverse {
//    给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//    示例：
//    二叉树：[3,9,20,null,null,15,7],

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //思路：队列实现 二叉树层次遍历
    // 队列是实现用linkedlist
    // 每次先入队根节点，后续开始循环判断，
    // 循环判断中需要预先准备list用于存放每层的输出输出
    // 每次从队列出输出节点时，将该节点的值存入临时list，
    // 同时判断左右子节点，是否为空，非空则入队
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null){
            return result;
        }
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> currentList = new ArrayList<Integer>();
            int levelSize = queue.size();
            for(int i=0;i<queue.size();i++){
                TreeNode node = queue.poll();
                if(node==null) continue;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                currentList.add(node.val);
            }
            result.add(currentList);
        }
        return result;
    }

}
