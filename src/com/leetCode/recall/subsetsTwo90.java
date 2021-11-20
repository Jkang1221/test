package com.leetCode.recall;

import java.util.*;

public class subsetsTwo90 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,4,4,1,4};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums);
        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[len];
        dfs(nums, path, res, len, 0, used);
        return res;
    }

    private static void dfs(int[] nums, Deque<Integer> path,
                            List<List<Integer>> res, int len, int index, boolean[] used) {
        res.add(new ArrayList<>(path));
        for (int i = index; i < len; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,path,res,len,i+1,used);
            used[i]= false;
            path.removeLast();
        }
    }
}
