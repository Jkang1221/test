package com.leetCode.recall;

import java.util.*;

public class pathSumTwo113 {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(9);
        TreeNode rightTree;
        TreeNode rleTree = new TreeNode(5);
        TreeNode rriTree = new TreeNode(8);
        rightTree = new TreeNode(4, rleTree, rriTree);
        TreeNode treeNode = new TreeNode(3, leftTree, rightTree);
        TreeNode treeNode2 = new TreeNode(4);
        System.out.println(pathSum(treeNode, 12));
        //System.out.println(pathSum(treeNode2, -1));
    }

    //    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        List<List<Integer>> res = new ArrayList<>();
//        System.out.println(res);
//        List<Integer> path = new ArrayList<>();
//        dfs(root, res, path, targetSum);
//        return res;
//    }
//    public static int sum = 0;
//    private static void dfs(TreeNode root, List<List<Integer>> res,
//                            List<Integer> path, int targetSum) {
//        if (root == null) {
//            return;
//        }
//        path.add(root.val);
//        sum += root.val;
//        if (root.left == null && root.right == null && sum == targetSum) {
//            res.add(new ArrayList<>(path));
//        }
//        dfs(root.left, res, path, targetSum);
//        dfs(root.right, res, path, targetSum);
//        path.remove(path.size()-1);
//        sum -= root.val;
//    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Integer> path = new LinkedList<>();
        int sum = 0;
        Deque<TreeNode> temp = new LinkedList<>();
        dfs(root, res, path, sum, targetSum, temp);
        return res;
    }

    private static void dfs(TreeNode root, List<List<Integer>> res,
                            Deque<Integer> path, int sum, int targetSum, Deque<TreeNode> temp) {
        if (root == null) {
            return;
        }
        temp.add(root);
        while (!temp.isEmpty()) {
            TreeNode node = temp.pollFirst();
            path.add(node.val);
            sum += node.val;
            if (sum == targetSum && root.left == null && root.right == null) {
                System.out.println(path);
                res.add(new ArrayList<>(path));
                return;
            }
            dfs(root.left, res, path, sum, targetSum, temp);
            if (!path.isEmpty() && path.size() != 1) {
                path.removeLast();
            }
            dfs(root.right, res, path, sum, targetSum, temp);
            if (!path.isEmpty() && path.size() != 1) {
                path.removeLast();
            }
        }
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
//    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (res == null) {
//            return res;
//        }
//        Deque<Integer> path = new LinkedList<>();
//        int sum = 0;
//        Deque<TreeNode> temp = new LinkedList<>();
//        dfs(root, res, path, sum, targetSum, temp);
//        return res;
//    }
//
//    private static void dfs(TreeNode root, List<List<Integer>> res,
//                            Deque<Integer> path, int sum, int targetSum, Deque<TreeNode> temp) {
//        if (sum == targetSum) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        if(root == null){return;}
//        temp.add(root);
//        while (!temp.isEmpty()) {
//            TreeNode node = temp.pollFirst();
//            path.add(node.val);
//            sum += node.val;
//            if (sum == targetSum) {
//                res.add(new ArrayList<>(path));
//                return;
//            }
//            if (sum < targetSum) {
//                dfs(root.left, res, path, sum, targetSum, temp);
//                path.removeLast();
//                dfs(root.right, res, path, sum, targetSum, temp);
//                if (!path.isEmpty() && path.size() != 1) {
//                    path.removeLast();
//                }
//            }
//            if (sum > targetSum) {
//                return;
//            }
//        }
//    }