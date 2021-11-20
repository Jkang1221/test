package com.leetCode.recall;

import java.util.*;

public class permutation47 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3};
        System.out.println(permuteUnique(nums).toString());

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[len + 1];
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, 0, len, used, path, res);
        return res;
    }

    private static void dfs(int[] nums, int index, int len,
                            boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,index+1,len,used,path,res);
            used[i]=false;
            path.removeLast();

        }
    }


/*    public static List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[len + 1];
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, res, 0, path, used, len);
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, int index,
                            Deque<Integer> path, boolean[] used, int len) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            dfs(nums, res, index + 1, path, used, len);
            used[i] = false;
            path.removeLast();
        }
    }*/
}
