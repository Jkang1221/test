package com.select;

import java.util.Arrays;
import java.util.Random;

public class quickSort1 {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 4, 1, 7, 9};
        quick1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quick1(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return;
        }
        quickSortRevision(nums, 0, len - 1);
    }

    private static void quickSortRevision(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partitionRevision1(nums, left, right);
        quickSortRevision(nums, left, p - 1);
        quickSortRevision(nums, p + 1, right);

    }

    private static final Random RANDOM = new Random();

    private static int partitionRevision1(int[] nums, int left, int right) {
        int random = left + RANDOM.nextInt(right - left + 1);
        swap1(nums, left, random);
        int pivot = nums[left];
        int lt = left;
        for (int i = left; i < right + 1; i++) {
            if (pivot > nums[i]) {
                lt++;
                swap1(nums, lt, i);
            }
        }
        swap1(nums, lt, left);
        return lt;
    }

    private static void swap1(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
