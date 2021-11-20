package com.leetCode.slidingWindow;

public class minimumSizeSubarraySum209 {
    public static void main(String[] args) {
        int target = 8;
        int[] nums = new int[]{1, 4, 4};
        System.out.println(minSubArrayLen(target, nums));

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int sum = 0;
        int right = 0, left = 0;
        int minLen = len + 1;
        while (right < len) {
            sum += nums[right];
            right++;
            while (sum >= target) {
                minLen = Math.min(right - left, minLen);
                sum = sum - nums[left];
                left++;
            }
        }
        return minLen == len + 1 ? 0 : minLen;
    }
}
