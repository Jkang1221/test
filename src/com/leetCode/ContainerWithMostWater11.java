package com.leetCode;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution11().maxArea(height));
    }
}
class Solution11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int s = 0;
        int max = (right - left)* (Math.min(height[left],height[right]));
        while (left < right){
            if(height[left] > height[right]){
                right--;
            }else {
                left++;
            }
            s = (right - left)* (Math.min(height[left],height[right]));
            if(s > max){
                max = s;
            }
        }
        return max;
    }
}
