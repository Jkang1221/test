package com.leetCode.selectTest;

public class reversePairsOffer51 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        SolutionOf51 solution = new SolutionOf51();
        System.out.println(solution.reversePairs(nums));
    }

}

class SolutionOf51 {
    //private static int count = 0;

    public int reversePairs(int[] nums) {
        int len = nums.length;
        //int count = 0;
        if(len < 2){
            return 0;
        }
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[len];
        //System.out.println(countReverse(copy, 0, len - 1,temp));
        return countReverse(copy, 0, len - 1, temp);
    }

    public int countReverse(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = (right - left) / 2 + left;
        int leftPairs = countReverse(nums, left, mid, temp);
        int rightPairs = countReverse(nums, mid + 1, right, temp);
        int crossPairs = countTwoReverse(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    public int countTwoReverse(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;

        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}