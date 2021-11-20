package com.leetCode.tree;

public class createBinaryPreIn105 {
    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preOrder, inOrder);
        String s = "";
        treeNode.printTree(treeNode, s);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new RuntimeException("error");
        }
        return build(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }

    private static TreeNode build(int[] preorder, int leftPre, int rightPre, int[] inorder, int leftIn, int rightIn) {
        if (leftPre > rightPre || leftIn > rightIn) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[leftPre]);
        int index = leftIn;
        while (inorder[index] != preorder[leftPre]) {
            index++;
        }
        root.left = build(preorder, leftPre + 1, index - leftIn + leftPre,
                inorder, leftIn, index - 1);
        root.right = build(preorder, index - leftIn + leftPre + 1, rightPre,
                inorder, index + 1, rightIn);
        return root;
    }
}
