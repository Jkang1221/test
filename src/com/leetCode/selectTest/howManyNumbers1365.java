package com.leetCode.selectTest;

import java.util.Arrays;

public class howManyNumbers1365 {
    public static void main(String[] args) {
        int[] nums = new int[]{7,7,7,7};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        int[] res = new int[len];
        int[] index = new int[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        mergeSort(nums, 0, len - 1, temp, index, res);
        System.out.println(Arrays.toString(index));
        for (int i = 1; i < len; i++) {
            //res[i] = index[i];
            if (nums[index[i]] == nums[index[i - 1]]) {
                res[index[i]] = res[index[i-1]];
            } else {
                res[index[i]] = i;
            }
        }
        return res;
    }

    private static void mergeSort(int[] nums, int left, int right, int[] temp, int[] index, int[] res) {
        if (left == right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        mergeSort(nums, left, mid, temp, index, res);
        mergeSort(nums, mid + 1, right, temp, index, res);
        mergeTwo(nums, left, mid, right, temp, index, res);
    }

    private static void mergeTwo(int[] nums, int left, int mid, int right, int[] temp, int[] index, int[] res) {
        for (int i = left; i <= right; i++) {
            temp[i] = index[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                index[k] = temp[j];
                j++;
            } else if (j > right) {
                index[k] = temp[i];
                //res[index[k]] += (right - mid);
                i++;
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                index[k] = temp[i];
                //res[index[k]] += (j - mid - 1);
                i++;
            } else {
                index[k] = temp[j];
                //res[index[k]] += (mid - i + 1);
                j++;
            }
        }
    }
}
