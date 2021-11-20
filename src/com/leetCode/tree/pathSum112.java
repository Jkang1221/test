package com.leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class pathSum112 {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(2);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(13);
        TreeNode rriTree = new TreeNode(4);
        rightTree = new TreeNode(8, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(5, leftTree, rightTree);
        int targetSum = 7;
        System.out.println(hasPathSum(treeNode, targetSum));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        if(root ==null){
            return false;
        }
        findSum(root, res, sum);
        if(res.contains(targetSum)){
            return true;
        }
        return false;
    }

    private static void findSum(TreeNode head, List<Integer> res, int sum) {
        sum += head.val;
        if(head.left!=null){
            findSum(head.left, res, sum);
        }
        if(head.right!=null){
            findSum(head.right, res, sum);
        }
        if (head.right==null&&head.left==null){
            res.add(sum);
        }
    }
}
