package com.leetcode_top;

import com.pojo.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class 重建二叉树_剑指07 {
    private Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0){
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int prebegin, int preend, int[] inorder, int inbegin, int inend){
        if(prebegin>preend||inbegin>inend){
            return null;
        }

        int rootval = preorder[prebegin];
        TreeNode root = new TreeNode(rootval);
        int rootIndxInorder = indexMap.get(rootval);

        TreeNode left = buildTreeHelper(preorder, prebegin+1, prebegin+rootIndxInorder-inbegin,
                inorder, inbegin, rootIndxInorder-1);
        TreeNode right = buildTreeHelper(preorder, rootIndxInorder+1, preend,
                inorder, rootIndxInorder+1, inend);
        root.left = left;
        root.right = right;
        return root;
    }

}
