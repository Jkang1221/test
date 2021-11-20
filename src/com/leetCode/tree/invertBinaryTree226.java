package com.leetCode.tree;

public class invertBinaryTree226 {
    public static void main(String[] args) {
        TreeNode l2 = new TreeNode(6);
        TreeNode le = new TreeNode(7, l2, null);
        TreeNode leftTree = new TreeNode(9, le, null);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        TreeNode newTree = invertTree(treeNode);
        String s = "";
        treeNode.printTree(treeNode, s);
        System.out.println("----");
        String s2 = "";
        newTree.printTree(newTree, s2);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode r = reverse(root, root.left, root.right);
        return r;
    }

    private static TreeNode reverse(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) {
            return root;
        }
        if (left != null) {
            left = reverse(left, left.left, left.right);
        }
        if (right != null) {
            right = reverse(right, right.left, right.right);
        }
        root = new TreeNode(root.val, right, left);
        return root;
    }
}
