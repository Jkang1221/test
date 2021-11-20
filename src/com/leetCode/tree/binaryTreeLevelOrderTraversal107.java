package com.leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeLevelOrderTraversal107 {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(9);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        //treeNode.setLefTreeNode(leftTree);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println(levelOrderBottom(treeNode).toString());
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> curLevel = new ArrayList<>();
            int curSize = queue.size();
            for (int i = 0;i<curSize;i++){
                TreeNode head = queue.poll();
                curLevel.add(head.val);
                if(head.left!=null){
                    queue.add(head.left);
                }
                if(head.right != null){
                    queue.add(head.right);
                }
            }
            res.add(0,curLevel);
        }
        return res;
    }

}
