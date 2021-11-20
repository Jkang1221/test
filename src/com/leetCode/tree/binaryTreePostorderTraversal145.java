package com.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePostorderTraversal145 {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(9);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println(postorderTraversal(treeNode).toString());
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
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
        dfs(head.left,res);
        dfs(head.right,res);
        res.add(head.val);
    }
}
