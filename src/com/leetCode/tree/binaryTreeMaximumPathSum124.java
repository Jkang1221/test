package com.leetCode.tree;

public class binaryTreeMaximumPathSum124 {
    //private static int max;

    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(9);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println(maxPathSum(treeNode));
    }
    private static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    private static int maxGain(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = Math.max(maxGain(root.left),0);
        int right = Math.max(maxGain(root.right),0);

        int sum = root.val+left+right;
        max = Math.max(max,sum);
        return root.val + Math.max(left,right);
    }
}
