package com.leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class symmetricTree101 {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(9);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        //treeNode.setLefTreeNode(leftTree);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println(isSymmetric(treeNode));
    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return (q.val == p.val) &&
                check(p.right, q.left) &&
                check(p.left, q.right);
    }

    public static boolean check2(TreeNode p,TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if (p==null||q==null){
                return false;
            }
            if(p.val!=q.val){
                return false;
            }
            queue.add(p.right);
            queue.add(q.left);

            queue.add(p.left);
            queue.add(q.right);
        }
        return true;
    }
}
