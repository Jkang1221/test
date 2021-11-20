package com.leetCode;

public class KokoEatingBananas875 {
    public static void main(String[] args) {
        int[] nums = new int[]{202220022};
        int h = 202220021;
        Solution875 solution875 = new Solution875();
        System.out.println(solution875.minEatingSpeed(nums, h));
    }
}

class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }
        int left = 1;
        int right = maxVal;


        while (left < right) {
            int mid = (right - left) / 2 + left;
            int sumHour = 0;
            for (int pile : piles) {
                sumHour = (mid+pile-1)/mid + sumHour;
            }

            if ( sumHour <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }


        }
        return left;
    }
}