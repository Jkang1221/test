package com.leetCode.recall;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class subsets78 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, res, path, 0, len,used);
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> path,
                            int index, int len, boolean[] used) {
        res.add(new ArrayList<>(path));

        for (int i = index;i<len;i++){
            if(used[i]){
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,res,path,i+1,len, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
