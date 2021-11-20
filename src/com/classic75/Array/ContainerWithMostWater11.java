package com.classic75.Array;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int max = 0;
        int area;
        while (left < right) {
            area = (right - left) * Math.min(height[left], height[right]);
            if (max < area) {
                max = area;
            }
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
