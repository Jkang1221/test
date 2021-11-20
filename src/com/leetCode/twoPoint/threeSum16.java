package com.leetCode.twoPoint;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

public class threeSum16 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int dif;
        int min = Integer.MAX_VALUE;
        int left, right;
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            left = i + 1;
            right = len - 1;
            while (left < right) {
                dif = target - (nums[right] + nums[left] + nums[i]);
                if (dif > 0) {
                    left++;
                } else if (dif < 0) {
                    right--;
                } else {
                    return target;
                }
                if (Math.abs(dif) < min){
                    sum = target-dif;
                    min = Math.abs(dif);
                }
            }

        }
        return sum;
    }
}
