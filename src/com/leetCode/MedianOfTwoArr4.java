package com.leetCode;

public class MedianOfTwoArr4 {
}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int totalLeft = (len1 + len2 + 1) / 2;
        int left = 0;
        int right = len1;
        // 在 nums1 的区间 [0, leftLength] 里查找恰当的分割线，
        // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        while (left < right) {
            int i = (right - left) / 2 + left;
            int j = totalLeft - i;
            if (nums2[j - 1] > nums1[i]) {
                left = i + 1;
            } else {
                right = j;
            }
        }
        int i = left;
        int j = totalLeft - i;
        int num1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int num1RightMin = i == len1 ? Integer.MAX_VALUE : nums1[i + 1];
        int num2LeftMax = j ==0 ? Integer.MIN_VALUE : nums2[j-1];
        int num2RightMin = j == len2 ? Integer.MAX_VALUE : nums2[j + 1];

        if((len1 + len2)%2 ==1){
            return Math.max(num1LeftMax,num2LeftMax);
        }else {
            return (double)((Math.max(num1LeftMax,num2LeftMax) + Math.min(num1RightMin,num2RightMin)))/2;
        }
    }
}