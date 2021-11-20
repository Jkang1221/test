package com.leetCode;

public class finshProblemLCP12 {
    public static void main(String[] args) {
        int[] time = new int[]{1,2,7,4,7,7};
        int m = 2;
        SolutionLCP12 solutionLCP12 = new SolutionLCP12();
        System.out.println(solutionLCP12.minTime(time, m));
    }
}

class SolutionLCP12 {
    public int minTime(int[] time, int m) {
        int left = 0;
        int max = 0;

        for (int num : time) {
            max += num;
        }
        int right = max;
        while (left < right) {
            int midHour = (right - left) / 2 + left;
            int day = findDays(time, midHour);
            if (day > m) {
                left = midHour + 1;
            } else {
                right = midHour;
            }
        }
        return left;

    }

    public int findDays(int[] time, int midHour) {
        int day = 1;
        int count = 0;
        int i = 0;
        int max = 0;
        while(i < time.length){
            max = Math.max(max,time[i]);
            count += time[i];
            if(count - max > midHour){
                day++;
                count = time[i];
                max = time[i];
            }
            i++;
        }
        return day;
    }
}