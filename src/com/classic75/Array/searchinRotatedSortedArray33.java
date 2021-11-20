package com.classic75.Array;

public class searchinRotatedSortedArray33 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        int target = 1;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int len = nums.length;
        int right = len - 1;
        int left = 0;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            //nums[left] < nums[mid]
            //[left,mid] 是有序数组
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target <= nums[mid]) {
/*                    if (target == nums[left]) {
                        return left;
                    } else if (target == nums[mid]) {
                        return mid;
                    } else {
                        right = mid;
                    }*/
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            //nums[left] > nums[mid]
            //[mid,right]是有序数组
            else {
                if (target >= nums[mid]&&target<=nums[right]){
/*                    if (target==nums[mid]){
                        return mid;
                    }else if (target == nums[right]){
                        return right;
                    }else{
                        left = mid + 1;
                    }*/
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}
