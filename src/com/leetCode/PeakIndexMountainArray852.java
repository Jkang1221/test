package com.leetCode;

public class PeakIndexMountainArray852 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,2,1,0};
        Solution852 solution852 = new Solution852();
        solution852.peakIndexInMountainArray(arr);
    }
}

class Solution852 {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (right - left)/2 + left;
            if (arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }else if(arr[mid] > arr[mid-1]&& arr[mid]<arr[mid+1]){
                left=mid +1;
            }else if(arr[mid] < arr[mid-1]){
                right = mid;
            }
        }
        return left;
    }
}