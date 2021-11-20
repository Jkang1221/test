package com.leetCode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeZigzag103 {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(9);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println((zigzagLevelOrder(treeNode)).toString());
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        //复习的时候补充
        return res;
    }
}
