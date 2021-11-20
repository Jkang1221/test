package com.classic75.dynamicProgramming;

public class climbingStairs {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(45));
    }

    public static int climbStairs(int n) {
        int[] nums = new int[n+1];
        nums[0]=0;
        nums[1]=1;
        nums[2]=2;
        for (int i = 3; i < nums.length; i++) {
            nums[i]=nums[i-1]+nums[i-2];
        }
        return nums[n];
    }
}
