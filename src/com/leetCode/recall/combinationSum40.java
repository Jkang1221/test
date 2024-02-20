package com.leetCode.recall;

import java.util.*;

public class combinationSum40 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,5,2,1,2};
        int target = 5;
        System.out.println(combinationSum2(nums, target).toString());
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len==0){
            return res;
        }
        boolean[] used = new boolean[len];
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,len,res,path,target,used);
        return res;
    }

    private static void dfs(int[] candidates, int begin, int len,
                            List<List<Integer>> res, Deque<Integer> path, int target, boolean[] used) {
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin;i<len;i++){
            if(target-candidates[i]<0){
                break;
            }
            if (i>0&&candidates[i]==candidates[i-1]&&!used[i-1]){
                continue;
            }
            path.addLast(candidates[i]);
            used[i]=true;
            dfs(candidates,i+1,len,res,path,target-candidates[i], used);
            path.removeLast();
            used[i] = false;
        }
    }
}
