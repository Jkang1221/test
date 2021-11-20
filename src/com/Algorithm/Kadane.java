package com.Algorithm;

public class Kadane {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(kadane(nums));
    }

    public static int kadane(int[] nums) {
        int len = nums.length;
        int curMax = 0;
        int resMax = 0;
        for (int i = 0; i < len; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            if (curMax > resMax) {
                resMax = curMax;
            }
        }
        return resMax;
    }
}
