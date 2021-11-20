package com.select;

import java.util.Arrays;
import java.util.Random;

public class quickSort2 {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 4, 1, 7, 9};
        quick2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quick2(int[] nums) {
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
        int p = partitionRevision2(nums, left, right);
        quickSortRevision(nums, left, p - 1);
        quickSortRevision(nums, p + 1, right);

    }

    private static final Random RANDOM = new Random();

    private static int partitionRevision2(int[] nums, int left, int right) {
        int random = left + RANDOM.nextInt(right - left + 1);
        swap(nums, left, random);
        int pivot = nums[left];
        int lt = left+1;
        int rt = right;
        while (true) {
            //从左边找到第一个大于等于pivot的数值
            while (lt <= rt && pivot > nums[lt]) {
                lt++;
            }
            //从右边找到第一个大于等于pivot的数值
            while (lt <= rt && pivot < nums[rt]) {
                rt--;
            }
            if (lt > rt) {
                break;
            }
            swap(nums, lt, rt);
            rt--;
            lt++;
        }
        swap(nums, rt, left);
        return rt;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
