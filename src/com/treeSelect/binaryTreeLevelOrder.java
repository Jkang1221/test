package com.treeSelect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeLevelOrder {
    public static void main(String[] args) {
        TreeNode lleTree = new TreeNode(4);
        TreeNode leftTree = new TreeNode(2, lleTree, null);
        TreeNode rightTree;
        TreeNode rriTree = new TreeNode(5);
        rightTree = new TreeNode(3, null, rriTree);

        TreeNode treeNode = new TreeNode(1, leftTree, rightTree);
        System.out.println((levelOrder(treeNode)).toString());
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
        return res.stream().mapToInt(i -> i).toArray();
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}