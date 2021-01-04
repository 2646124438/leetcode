package com.util;

import com.pojo.TreeNode;
import org.junit.Test;


class TreeBuilderUtilTest {

    @Test
    void buildBinaryTree() {
        Integer[] nums = new Integer[]{1,2,3,null,null,4,5};
        TreeNode treeNode = TreeBuilderUtil.buildBinaryTree(nums,0);
        System.out.println(treeNode);
    }
}