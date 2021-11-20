package com.leetCode.selectTest;

import java.util.Arrays;

public class mergeSortedArray88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        merge(nums1,m,nums2,n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        for (int i =0;i<m;i++){
            tmp[i] = nums1[i];
        }
        int i = 0;
        int j = 0;
        for(int k = 0;k<nums1.length;k++){
            if(i == m){
                nums1[k] = nums2[j];
                j++;
            }else if(j == n){
                nums1[k] = tmp[i];
                i++;
            }else if(tmp[i]>nums2[j]){
                nums1[k]=nums2[j];
                j++;
            }else {
                nums1[k]=tmp[i];
                i++;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

}
