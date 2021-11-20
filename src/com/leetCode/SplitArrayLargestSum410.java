package com.leetCode;

public class SplitArrayLargestSum410 {
    public static void main(String[] args) {
        Solution410 solution410 = new Solution410();
        int[] nums = new int[]{7, 2, 5, 10, 8};
        int m = 2;
        System.out.println(solution410.splitArray(nums, m));
    }
}

class Solution410 {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int spilts = spilt(nums, mid);
            if (spilts <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int spilt(int[] nums, int maxSum) {
        int spilts = 1;
        int curSum = 0;
        for (int num : nums) {
            if (curSum + num > maxSum) {
                spilts++;
                curSum = 0;
            }
            curSum += num;
        }
        return spilts;
    }
}