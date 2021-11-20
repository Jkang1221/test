package com.leetCode.selectTest;

import java.util.Arrays;

public class rotateArray189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        //rotate2(nums,k);

    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] newNums = new int[len];
        for (int i = 0; i < len; i++) {
            newNums[(i + k) % len] = nums[i];
        }
        System.out.println(Arrays.toString(newNums));
        System.out.println(Arrays.toString(nums));
        System.arraycopy(newNums, 0, nums, 0, len);
        System.out.println(Arrays.toString(newNums));
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.out.println(Arrays.toString(newArr));
        System.out.println(Arrays.toString(nums));
        System.arraycopy(newArr, 0, nums, 0, n);
        System.out.println(Arrays.toString(newArr));
        System.out.println(Arrays.toString(nums));
    }
}
