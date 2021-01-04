package com.util;

import com.pojo.TreeNode;

public class TreeBuilderUtil {

    /**
     * 构建二叉树
     * @param nums　输入数组
     * @param index　索引开始位置
     * @return
     */
    public static TreeNode buildBinaryTree(Integer[] nums, int index){
        TreeNode tn = null;
        if(index<nums.length){
            if(nums[index]!=null) {
                tn = new TreeNode(nums[index]);
                tn.left = buildBinaryTree(nums, 2 * index + 1);
                tn.right = buildBinaryTree(nums, 2 * index + 2);
            }
        }
        return tn;
    }

    /**
     * 根据数组构建一般的树
     * @param nums
     * @param index
     * @return
     */
    public static TreeNode buildNormalTree(Integer[] nums, int index){
        return null;
    }

}
