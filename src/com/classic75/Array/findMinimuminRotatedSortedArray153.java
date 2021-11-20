package com.classic75.Array;

public class findMinimuminRotatedSortedArray153 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            //最小值的左侧严格大于nums[right]，最小值的右侧严格小于nums[right]
            //与最右边的值像比较，判断nums[mid]是在最小值的左侧还是右侧
            int mid = (right - left) / 2 + left;
            if (nums[mid]>nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
