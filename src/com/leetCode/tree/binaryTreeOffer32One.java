package com.leetCode.tree;

import java.util.*;

public class binaryTreeOffer32One {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(9);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println(Arrays.toString(levelOrder(treeNode)));
    }

    public static int[] levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode head = queue.poll();
                res.add(head.val);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
        }
       // System.out.println(res.toString());
        return res.stream().mapToInt(i -> i).toArray();
    }
}
