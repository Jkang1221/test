package com.leetCode.tree;

public class constructBinaryPreIn105 {
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
            return null;
        }
        return build(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }

    private static TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode pivot = new TreeNode(preorder[preLeft]);
        int index = inLeft;
        while (preorder[preLeft] != inorder[index]) {
            index++;
        }
        pivot.left = build(preorder, preLeft + 1, index - inLeft + preLeft,
                inorder, inLeft, index - 1);
        pivot.right = build(preorder, index - inLeft + preLeft + 1, preRight,
                inorder, index + 1, inRight);
        return pivot;
    }
}
