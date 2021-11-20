package com.select;

import java.util.Arrays;

public class mergeSelect {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] res = solution.sortArray(nums);
        System.out.println(Arrays.toString(res));
    }

}
class Solution {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        mergeSort(nums, 0, len - 1, 0);
        return nums;
    }
    private void mergeSort(int[] nums, int left, int right, int depthForDebug) {
        System.out.println("divide (" + left + ", " + right + ")");
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, depthForDebug + 1);
        mergeSort(nums, mid + 1, right, depthForDebug + 1);
        System.out.println("conquer (" + left + ", " + right + ")");
        mergeOfTwoSortedArray(nums, left, mid, right);
    }
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right) {
        int len = right - left + 1;
        int[] temp = new int[len];

        for (int i = 0; i < len; i++) {
            temp[i] = nums[left + i];
        }

        int i = 0;
        int j = mid - left + 1;
        for (int k = 0; k < len; k++) {
            //处理越界情况
            if (i == mid + 1 - left) {
                nums[left + k] = temp[j];
                j++;
            } else if (j == right + 1 - left) {
                nums[left + k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[left + k] = temp[i];
                i++;
            } else {
                nums[left + k] = temp[j];
                j++;
            }
        }
    }


}