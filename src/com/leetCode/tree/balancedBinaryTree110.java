package com.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class balancedBinaryTree110 {
    public static void main(String[] args) {
        TreeNode l2 = new TreeNode(6);
        TreeNode le = new TreeNode(7, l2, null);
        TreeNode leftTree = new TreeNode(9, le, null);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println(isBalanced(treeNode));
        String s = "";
        //treeNode.printTree(treeNode, s);
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int depthR = findDepth(root.right);
        int depthL = findDepth(root.left);
        System.out.println(depthL);
        System.out.println(depthR);
        if (Math.abs(depthL - depthR) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        } else {
            return false;
        }
    }

    private static int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
    }

    public static boolean isBalanced2(TreeNode root) {
        return findDepth2(root) >= 0;
    }

    private static int findDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findDepth2(root.left);
        int right = findDepth2(root.right);
        if (left == -1 || right == -1 || Math.abs(right - left) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

}
