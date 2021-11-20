package com.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class minimumDepthofBinarytree111 {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(9);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(15);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(20, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        System.out.println(minDepth(treeNode));
    }
    public static int minDepth(TreeNode root) {
        int depth = 0;
        if(root == null){
            return depth;
        }
        List<Integer> res = new ArrayList<>();
        findLeaf(root,depth+1,res);
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<res.size();i++){
            if(min>res.get(i)){
                min = res.get(i);
            }
        }
        System.out.println(res.toString());
        return min;
    }

    private static void findLeaf(TreeNode root, int depth, List<Integer> res) {
        if(root == null){
            return;
        }
        if(root.right==null&&root.left==null){
            res.add(depth);
        }
        findLeaf(root.left,depth+1,res);
        findLeaf(root.right,depth+1,res);
    }
}
