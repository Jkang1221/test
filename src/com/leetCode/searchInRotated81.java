package com.leetCode;

public class searchInRotated81 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,2,0,2};
        int target = 0;
        Solution81 solution81 = new Solution81();
        System.out.println(solution81.search(nums, target));
    }
}

class Solution81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[left] < nums[mid]) {
                if (nums[mid] >= target && target >= nums[left]) {
                    if (nums[left] == target) {
                        return true;
                    } else if (nums[mid] == target) {
                        return true;
                    } else {
                        right = mid;
                    }
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) {
                    if (nums[right] == target) {
                        return true;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    right = mid;
                }
            } else if(nums[left]==nums[mid]) {
                if (target == nums[left] || target == nums[right]) {
                    return true;
                } else{
                    left++;
                    right--;
                }
            }
        }
        if (nums[left] == target|| target == nums[right]) {
            return true;
        }
        return false;
    }
}