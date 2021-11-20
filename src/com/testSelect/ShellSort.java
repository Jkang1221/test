package com.testSelect;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[]{45,21,5,12,6};
        System.out.println(Arrays.toString(sortArray(nums)));
    }
    public static int[] sortArray(int[] nums) {
        int len = nums.length;
        int h = 1;

        int gap = len / 2;
        while (gap >= 1) {
            // 缩小增量的插入排序
            for (int i = h; i < len; i++) {
                insertionForDelta(nums, gap, i);
            }
            gap /= 2;
        }
        return nums;
    }

    /**
     * 将 nums[end] 插入到对应分组的正确位置上，其实就是将原来 1 的部分改成 gap
     *
     * @param nums
     * @param gap  间隔
     * @param end
     */
    private static void insertionForDelta(int[] nums, int gap, int end) {
        int temp = nums[end];
        int j = end;
        while (j >= gap && nums[j - gap] > temp) {
            nums[j] = nums[j - gap];
            j -= gap;
        }
        nums[j] = temp;
    }
}
