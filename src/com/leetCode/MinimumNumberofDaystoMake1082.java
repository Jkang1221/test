package com.leetCode;

public class MinimumNumberofDaystoMake1082 {
    public static void main(String[] args) {
        int[] bloomDay = new int[]{7, 7, 7, 7, 12, 7, 7};
        int m = 2;
        int k = 3;
        Solution1082 solution1082 = new Solution1082();
        System.out.println(solution1082.minDays(bloomDay, m, k));
    }
}

class Solution1082 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (m * k)) {
            return -1;
        }
        int max = 0;
        int min = 1;
        for (int num : bloomDay) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int left = min;
        int right = max;
        while (left < right) {
            //midDay 是需要多少天
            int midDay = (right - left) / 2 + left;
            //countM 是指的在midDay时可以制作多少花
            int countM = mayDay(bloomDay, k, midDay);
            if (countM >= m) {
                right = midDay;
            } else {
                left = midDay + 1;
            }
        }
        if (left <= max) {
            return left;
        }
        return -1;
        //return -1;
    }

    public int mayDay(int[] bloomDay, int k, int midDay) {
        //count 连续多少朵
        //countM 多少朵花可以制作
        int count = 0;
        int countM = 0;
        int[] mid = new int[bloomDay.length];
        for (int i = 0; i < bloomDay.length; i++) {
            if (midDay >= bloomDay[i]) {
                mid[i] = 1;
            } else {
                mid[i] = 0;
            }
        }
        int i = 0;
        for (int num : mid) {
            count++;
            if (num == 0) {
                count = 0;
            }
            if (count == k) {
                countM++;
                count = 0;
            }

            i++;
        }
        return countM;
    }
}