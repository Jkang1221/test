package com.leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeRightSideView199 {
    public static void main(String[] args) {
        TreeNode l2=new TreeNode(6);
        TreeNode le = new TreeNode(7,l2,null);
        TreeNode leftTree = new TreeNode(9,le,null);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println(rightSideView(treeNode).toString());
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode head = queue.poll();
                curLevel.add(head.val);
                if (head.right != null) {
                    queue.add(head.right);
                }
                if (head.left != null) {
                    queue.add(head.left);
                }
            }
            res.add(curLevel);
        }
        System.out.println(res);
        for (int i = 0; i < res.size(); i++) {
            resList.add(res.get(i).get(0));
        }
        return resList;
    }
}
