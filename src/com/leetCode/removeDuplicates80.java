package com.leetCode;

import java.util.Arrays;

public class removeDuplicates80 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 2, 2, 3, 5, 6};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int fast = 2;
        int slow = 2;

        while (fast < len) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
                System.out.println(Arrays.toString(nums));
            }
            fast++;
        }
        return slow;
    }
}
