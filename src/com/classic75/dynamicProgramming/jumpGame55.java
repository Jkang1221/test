package com.classic75.dynamicProgramming;

import java.util.HashSet;

public class jumpGame55 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int target = nums.length;
        HashSet hs = new HashSet();
        int i = nums[0];
        hs.add(i);
        while(i<target){
            i = nums[i]+i;
            // j
        }
        return true;
    }
}
