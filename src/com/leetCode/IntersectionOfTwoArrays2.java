package com.leetCode;

import java.util.Arrays;

public class IntersectionOfTwoArrays2 {
}

class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int i=0,j=0,k=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] num = new int[Math.min(nums1.length,nums2.length)];
        while(i < nums1.length && j < nums2.length){
            if(nums1[i]==nums2[j]){
                num[k]=nums1[i];
                i++;
                j++;
                k++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }
        }
        return Arrays.copyOfRange(num,0,k);

    }
}