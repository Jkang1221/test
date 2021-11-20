package com.leetCode;

public class SearchInsertPosition35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.searchInsert(nums, target));
    }
}

class Solution3 {
/*    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        int ans = nums.length;
        while(left <= right){
            mid = ((right - left)>>1)+left;
            if(nums[mid]>=target){
                ans=mid;
                right=mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }*/
 /*   public int searchInsert(int[] nums, int target) {
        int start=0,end=nums.length-1;
        int mid=0;
        while(start<=end){
            mid=start+(end-start)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target) start=mid+1;
            if(nums[mid]>target) end=mid-1;
        }
        return target<nums[mid]? mid : ++mid;
        //方式三：
 *//*       while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        return left;*//*

    }*/

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                //ans = left;
                left = mid + 1;
            }
        }

        return left;
    }


}