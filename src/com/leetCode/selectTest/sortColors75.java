package com.leetCode.selectTest;

import java.util.Random;

public class sortColors75 {
    public static void main(String[] args) {

    }
    public static void sortColors(int[] nums) {
        quick2(nums);
    }
    public static void quick2(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return;
        }
        partitionRevision3(nums, 0, len - 1);
    }

    private static final Random RANDOM = new Random();

    private static void partitionRevision3(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int random = left + RANDOM.nextInt(right - left + 1);
        swap(nums, left, random);
        int pivot = nums[left];
        int lt = left;
        int rt = right + 1;
        int i = left + 1;
        while (i < rt) {
            if (nums[i] == pivot) {
                i++;
            } else if (nums[i] > pivot) {
                rt--;
                swap(nums, i, rt);
                //i++;
            } else {
                lt++;
                swap(nums, i, lt);
                i++;
            }
        }
        swap(nums, lt, left);
        partitionRevision3(nums, left, lt - 1);
        partitionRevision3(nums, rt, right);
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
