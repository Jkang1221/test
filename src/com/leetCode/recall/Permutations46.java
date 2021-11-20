package com.leetCode.recall;

import java.util.*;

public class Permutations46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums).toString());
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len==0){
            return res;
        }
        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[len+1];
        dfs(nums,0,len,used,path,res);
        return res;
    }

    private static void dfs(int[] nums, int index, int len, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if(index == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0;i<len;i++){
            if(used[i]){
                continue;
            }
            used[i]=true;
            path.addLast(nums[i]);
            dfs(nums,index+1,len,used,path,res);
            path.removeLast();
            used[i]=false;
        }
    }
}
