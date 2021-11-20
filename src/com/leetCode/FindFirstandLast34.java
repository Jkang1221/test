package com.leetCode;

public class FindFirstandLast34 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 7,7, 8, 10};
        int target = 7;
        Solution34 solution34 = new Solution34();
        System.out.println(solution34.searchRange(nums, target)[0]);
        System.out.println(solution34.searchRange(nums, target)[1]);
    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int start = searchFirst(nums, target);
        if (start == -1) {
            return new int[]{-1, -1};
        }
        int end = searchLast(nums,target);
        return new int[]{start, end};
    }

    private int searchFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int searchLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (target >= nums[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;

    }
}