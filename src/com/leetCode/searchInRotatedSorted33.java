package com.leetCode;

public class searchInRotatedSorted33 {
    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int[] nums = new int[]{1, 3, 5};
        int target = 1;
        System.out.println(solution33.search(nums, target));
    }
}

class Solution33 {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1; }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    if (target == nums[left]) {
                        right = left;
                    } else if (target == nums[mid]) {
                        right = mid;
                        left = mid;
                    } else {
                        right = mid; }
                } else {
                    left = mid + 1; }
            } else {
                if (target>=nums[mid] && target <= nums[right]){
                    if (target == nums[right]){
                        left=right;
                    }else if(target == nums[mid]){
                        right = mid;
                        left = mid;
                    } else {
                        left= mid+1; }
                }else {
                    right = mid;} } }
        return nums[left] == target ? left : -1;
    }
}