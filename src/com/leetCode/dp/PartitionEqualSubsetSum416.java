package com.leetCode.dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) return false;
        //化为01背包问题，weight和value都是nums[]
        //bagweight 是sum/2
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

}
