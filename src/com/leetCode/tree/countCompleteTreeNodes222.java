package com.leetCode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class countCompleteTreeNodes222 {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(9);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        //treeNode.setLefTreeNode(leftTree);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println(countNodes(treeNode));
    }

    public static int countNodes(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode head = queue.poll();
                sum++;
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
        }
        return sum;
    }

    public static int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = levelTree(root.left);
        int right = levelTree(root.right);
        if (left == right) {
            return (1 << left) + countNodes2(root.right);
        } else {
            return (1 << right) + countNodes2(root.left);
        }
    }

    public static int levelTree(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}
