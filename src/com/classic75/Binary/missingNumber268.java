package com.classic75.Binary;

public class missingNumber268 {
    public static void main(String[] args) {
        int[] nums = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber2(nums));
    }
    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int standSum = (len*(len+1))/2;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        return standSum-sum;
    }
    public static int missingNumber2(int[] nums) {
        int len = nums.length;
        int miss = nums.length;
        for (int i = 0; i < len; i++) {
            miss  = miss ^i^nums[i];
        }
        return miss;
    }
}
