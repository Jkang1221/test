package com.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class binaryTreeInorder94 {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(9);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println(inorderTraversal(treeNode).toString());
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        dfs(root,res);
        return res;
    }
    public static void dfs(TreeNode head, List<Integer> res){
        if(head ==null){
            return;
        }
        dfs(head.left,res);
        res.add(head.val);
        dfs(head.right,res);
    }
}
