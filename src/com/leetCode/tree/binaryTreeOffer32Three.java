package com.leetCode.tree;

import java.util.*;

public class binaryTreeOffer32Three {
    public static void main(String[] args) {
        TreeNode lleTree = new TreeNode(4);
        TreeNode leftTree = new TreeNode(2, lleTree, null);
        TreeNode rightTree;
        TreeNode rriTree = new TreeNode(5);
        rightTree = new TreeNode(3, null, rriTree);

        TreeNode treeNode = new TreeNode(1, leftTree, rightTree);
        System.out.println((levelOrder(treeNode)).toString());
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode head = queue.poll();
                curLevel.add(head.val);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
            if(level%2==1){
                res.add(curLevel);
            }else {
                Collections.reverse(curLevel);
                res.add(curLevel);
            }
            level++;
        }
        return res;
    }
}
