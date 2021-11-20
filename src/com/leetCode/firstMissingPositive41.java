package com.leetCode;

import java.util.HashMap;

public class firstMissingPositive41 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive2(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        HashMap hashMap = new HashMap();
        for (int i = 0;i<nums.length;i++){
            hashMap.put(nums[i],1);
        }
        for (int i = 1;i<=nums.length+1;i++){
            if (!hashMap.containsKey(i)){
                return i;
            }
        }
        return -1;
    }
    public static int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] - 1 != i) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                //System.out.println(nums[nums[i] - 1]);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0 || nums[i] > n) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
