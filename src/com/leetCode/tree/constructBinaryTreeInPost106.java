package com.leetCode.tree;

public class constructBinaryTreeInPost106 {
    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree(inorder, postorder);
        String s = "";
        treeNode.printTree(treeNode, s);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        if (inLen != postLen) {
            throw new RuntimeException("error");
        }
        return build(inorder, 0, inLen - 1, postorder, 0, postLen - 1);
    }

    private static TreeNode build(int[] inorder, int leftIn, int rightIn, int[] postorder, int leftPo, int rightPo) {
        if (leftIn > rightIn || leftPo > rightPo) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[rightPo]);
        int index = leftIn;
        while (inorder[index] != postorder[rightPo]) {
            index++;
        }
        root.left = build(inorder, leftIn, index - 1, postorder, leftPo, index - 1 - leftIn +leftPo);
        root.right = build(inorder, index + 1, rightIn, postorder, index - leftIn + leftPo, rightPo - 1);
        return root;
    }
}
