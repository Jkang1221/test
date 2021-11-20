package com.leetCode.twoPoint;

import java.util.Arrays;

public class twoSum167 {
    public static void main(String[] args) {
        int[] num = new int[]{5, 25, 75};
        int target = 100;
        System.out.println(Arrays.toString(twoSum(num, target)));

    }

    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int left;
        int right = len - 1;
        int sum;
        for (int i = 0; i < len; i++) {
            left = i;
            while (left < right) {
                sum = numbers[left] + numbers[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return new int[]{left + 1, right + 1};
                }

            }
        }
        return new int[]{0, 0};
    }
}
