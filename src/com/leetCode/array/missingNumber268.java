package com.leetCode.array;

import java.util.Arrays;
import java.util.Random;

public class missingNumber268 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2};
        System.out.println(missingNumber3(nums));
    }

    //方法一
    public static int missingNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return len;
    }

    //方法二
    public static int missingNumber2(int[] nums) {
        int len = nums.length;
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < len; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return len;
    }

    public static void quickSort(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        quick(nums, 0, len - 1);
    }

    private static final Random RANDOM = new Random();

    private static void quick(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int random = left + RANDOM.nextInt(right - left + 1);
        swap(random, left, nums);
        int pivot = nums[left];
        int i = left + 1;
        int lt = left;
        int rt = right + 1;
        while (i < rt) {
            if (pivot < nums[i]) {
                rt--;
                swap(rt, i, nums);
            } else if (pivot > nums[i]) {
                lt++;
                swap(lt, i, nums);
                i++;
            }
        }
        swap(lt, left, nums);
        quick(nums, left, lt - 1);
        quick(nums, lt + 1, right);
    }

    public static void swap(int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    //  方法三
    public static int missingNumber3(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int standSum = len*(len+1)/2;
        for (int i = 0;i<len;i++){
            sum+=nums[i];
        }

        return standSum-sum;
    }
}
