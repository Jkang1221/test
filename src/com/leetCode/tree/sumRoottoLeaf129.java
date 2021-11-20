package com.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class sumRoottoLeaf129 {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(2);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(9);
        TreeNode rriTree = new TreeNode(4);
        rightTree = new TreeNode(8, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(5, leftTree, rightTree);
        System.out.println(sumNumbers(treeNode));
    }

    //public  static  int sum = 0;
    public static int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        String temp = "";
        List<String> sumList1 = new ArrayList<>();
        sumNode1(root, temp, sumList1);
        List<Integer> temp2 = new ArrayList<>();
        List<List<Integer>> sumList2 = new ArrayList<>();
        //System.out.println(temp);
        sumNode2(root, temp2, sumList2);
        //System.out.println(sumList.toString());
        return 0;
    }
    private static void sumNode(TreeNode root, int temp, List<Integer> sumList) {
        temp = temp * 10 + root.val;
        if (root.left != null) {
            sumNode(root.left, temp, sumList);
        }
        if (root.right != null) {
            sumNode(root.right, temp, sumList);
        }
        if (root.right == null && root.left == null) {
            sumList.add(temp);
        }
    }

    private static void sumNode1(TreeNode root, String temp, List<String> sumList) {
        if (root != null) {
            StringBuffer pa = new StringBuffer(temp);
            //System.out.println(temp);
            pa.append(root.val);
            //Bool pa = new StringBuffer(temp);
            if (root.right == null && root.left == null) {
                sumList.add(pa.toString());
            } else {
                //pa.append("->");
                //System.out.println(pa.toString());
                sumNode1(root.left, pa.toString(), sumList);
                sumNode1(root.right, pa.toString(), sumList);
            }
        }
    }

    private static void sumNode2(TreeNode root, List<Integer> temp, List<List<Integer>> sumList) {
        List<Integer> te = new ArrayList<>(temp);
        te.add(root.val);
        System.out.println(te);
        if (root.left != null) {
            sumNode2(root.left, te, sumList);
        }
        if (root.right != null) {
            sumNode2(root.right, te, sumList);
        }
        if (root.right == null && root.left == null) {
            sumList.add(te);
            //System.out.println(sumList);
        }
    }
}
