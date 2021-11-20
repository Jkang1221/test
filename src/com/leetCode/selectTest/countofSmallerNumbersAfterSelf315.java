package com.leetCode.selectTest;

import java.util.ArrayList;
import java.util.List;

public class countofSmallerNumbersAfterSelf315 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 9, 7, 8, 5};
        System.out.println(countSmaller(nums));
    }

    public static List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        if (len < 2) {
            list.add(0);
            return list;
        }
        int[] temp = new int[len];
        int[] index = new int[len];
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        mergeSorted(nums, 0, len - 1, temp, index, res);
        for (int i = 0; i < len; i++) {
            list.add(res[i]);
        }
        return list;
    }

    private static void mergeSorted(int[] nums, int left, int right, int[] temp, int[] index, int[] res) {
        if (left == right) {
            return;
        }
        int mid = (right - left) / 2 + left;
        mergeSorted(nums, left, mid, temp, index, res);
        mergeSorted(nums, mid + 1, right, temp, index, res);
        mergeTwoArray(nums, left, mid, right, temp, index, res);
    }

    private static void mergeTwoArray(int[] nums, int left, int mid, int right, int[] temp, int[] index, int[] res) {
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
                res[index[k]] += (right - mid);
                i++;
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                index[k] = temp[i];
                res[index[k]] += (j - mid - 1);
                i++;
            } else {
                index[k] = temp[j];
                //res[index[i]] += (right - j +1);
                j++;
            }
        }
    }
}
