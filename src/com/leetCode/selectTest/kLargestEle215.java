package com.leetCode.selectTest;

import java.util.Arrays;
import java.util.Random;


public class kLargestEle215 {
    private static final Random RANDOM = new Random();
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,2,7};
        int k = 2;
        System.out.println(findKthLargest(nums,k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        System.out.println(Arrays.toString(nums));
        return nums[k-1];
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(nums, left, right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int ra  = left + RANDOM.nextInt(right - left + 1);
        swap(nums,ra,left);
        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > pivot) {
                lt++;
                swap(nums, lt, i);
            }
        }
        swap(nums,left,lt);
        return lt;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
