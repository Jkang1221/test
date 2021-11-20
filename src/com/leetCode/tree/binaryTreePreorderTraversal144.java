package com.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePreorderTraversal144 {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(9);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println(preorderTraversal(treeNode).toString());
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        if(root == null){
            return res;
        }
        dfs(root,res);
        return res;
    }

    private static void dfs(TreeNode head, List<Integer> res) {
        if(head == null){
            return;
        }
        res.add(head.val);
        dfs(head.left,res);
        dfs(head.right,res);
    }
}
