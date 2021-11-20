package com.leetCode.tree;

public class maximumDepthofBinaryTree104 {
    public static void main(String[] args) {
        TreeNode l2 = new TreeNode(6);
        TreeNode le = new TreeNode(7, l2, null);
        TreeNode leftTree = new TreeNode(9, le, null);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println(maxDepth(treeNode));
        String s = "";
        //treeNode.printTree(treeNode, s);
    }
    public static int maxDepth(TreeNode root) {
        return depth(root);
    }

    private static int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}
