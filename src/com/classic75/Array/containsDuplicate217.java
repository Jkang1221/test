package com.classic75.Array;

import java.util.HashSet;

public class containsDuplicate217 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (res.contains(nums[i])){
                return true;
            }
            res.add(nums[i]);
        }
        return false;
    }
}
