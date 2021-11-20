package com.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class diameterofBinaryTree543 {


    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(9);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println((diameterOfBinaryTree(treeNode)));
    }
    private static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        findDepeth(root);
        return max;
    }

    private static int findDepeth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findDepeth(root.left);
        int right = findDepeth(root.right);
        max = Math.max(max,right+left);
        return Math.max(left,right)+1;
    }
}
