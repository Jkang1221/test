package com.classic75.Array;

public class maximumSubarray53 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int cur = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            if (res < cur) {
                res = cur;
            }
        }
        return res;
    }
}
