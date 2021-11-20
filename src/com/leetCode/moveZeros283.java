package com.leetCode;

import java.util.Arrays;

public class moveZeros283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2,1};
        new Solution283().moveZeroes(nums);
    }
}

class Solution283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0, j = 0;
        while (i < len) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
            i++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public void swap(int[] nums, int index1, int index2) {
        int tem = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tem;
    }
}