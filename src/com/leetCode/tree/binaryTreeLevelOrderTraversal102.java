package com.leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeLevelOrderTraversal102 {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(9);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println(levelOrder(treeNode).toString());
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int curLen = queue.size();
            for (int i = 0; i < curLen; i++) {
                TreeNode head = queue.poll();
                curLevel.add(head.val);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
            res.add(curLevel);
        }
        return res;
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

    public TreeNode createTree(Integer[] nums) {
        TreeNode root = null;
        TreeNode point;
        Queue<TreeNode> queue = new LinkedList<>();
        if (nums.length >= 1) {
            root = new TreeNode(nums[0]);
            queue.add(root);
        }
        int i = 1;
        while (i < nums.length) {
            point = queue.poll();
            if (null != nums[i]) {
                point.left = new TreeNode(nums[i]);
                queue.add(point.left);
            }
            i++;
            if (i >= nums.length) {
                break;
            }
            if (null != nums[i]) {
                point.right = new TreeNode(nums[i]);
                queue.add(point.right);
            }
            i++;
        }
        return root;
    }

    public void printTree(TreeNode treeNode, String str) {
        if (null == treeNode) {
            return;
        } else {
            printTree(treeNode.left, str + "**");
            System.out.println(str + treeNode.val);
            printTree(treeNode.right, str + "**");
        }
    }
}
