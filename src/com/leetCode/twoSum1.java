package com.leetCode;

import java.util.Arrays;

public class twoSum1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 18;
        System.out.println(Arrays.toString(new Solution1().twoSum(nums, target)));
    }
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int sum = 0;
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j) {
                    sum = nums[i] + nums[j];
                    if (sum == target) {
                        ans[0] = i;
                        ans[1] = j;
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}