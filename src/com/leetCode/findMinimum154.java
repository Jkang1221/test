package com.leetCode;

public class findMinimum154 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,3,1,3};
        Solution154 solution154 = new Solution154();
        System.out.println(solution154.findMin(nums));
    }
}
class Solution154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (right - left)/2 +left;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }else {
                right = right - 1;
            }
        }
        return nums[left];

    }
}