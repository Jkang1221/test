package com.leetCode;

public class findMinimum153 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,1,3};
        Solution153 solution153 = new Solution153();
        System.out.println(solution153.findMin(nums));
    }
}
class Solution153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (right - left)/2 +left;
            if(nums[mid] >= nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}