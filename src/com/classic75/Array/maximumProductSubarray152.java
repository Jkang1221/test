package com.classic75.Array;

public class maximumProductSubarray152 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int imax = 1;
        int imin = 1;
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            //
            if (nums[i] < 0) {
                int temp = imin;
                imin = imax;
                imax = temp;
            }
            //如果nums[i] 是正数，希望imax越大越好。
            //如果nums[i]是负数，希望imin越小越好。
            //在第二次遇到负数时会把imax与imin交换位置，这样得出来的imax是最大的。
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}
