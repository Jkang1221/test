package com.leetCode.recall;

import java.util.*;

public class combinationSum39 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(nums, target).toString());
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new LinkedList<>();
        dfs2(candidates, 0, res, target, path);
        return res;
    }
    //多叉树解决问题
    private static void dfs(int[] candidates, int index, List<List<Integer>> res, int target, Deque<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target-candidates[i]<0){
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, i, res, target - candidates[i], path);
            path.removeLast();
        }
    }
    //二叉树解决问题
    private static void dfs2(int[] candidates,
                             int index, List<List<Integer>> res, int target, Deque<Integer> path) {
        if(index == candidates.length){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        dfs2(candidates, index+1, res, target, path);
        if(target-candidates[index]>=0){
            path.addLast(candidates[index]);
            dfs2(candidates, index, res, target - candidates[index], path);
            path.removeLast();
        }
    }

}
