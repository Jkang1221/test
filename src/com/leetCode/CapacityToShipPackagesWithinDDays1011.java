package com.leetCode;

public class CapacityToShipPackagesWithinDDays1011 {
    public static void main(String[] args) {
        int[] weights = new int[]{1,2,3,1,1};
        int day = 4;
        Solution1011 solution1011 = new Solution1011();
        System.out.println(solution1011.shipWithinDays(weights, day));
    }

}
class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for(int num: weights){
            max = Math.max(max,num);
            sum += num;
        }
        int left = max;
        int right = sum;
        while (left < right){
            int mid = (right - left)/2 + left;
            int day = day(weights,mid);
            if(day > days){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    public int day(int[] weights, int sumMax){
        int days = 1;
        int sum = 0;
        for (int num : weights) {
            if(sum + num > sumMax){
                days++;
                sum = 0;
            }
            sum += num;
        }
        return days;

    }
}