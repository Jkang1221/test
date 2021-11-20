package com.leetCode.twoPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return res;
        }
        Arrays.sort(nums);
        int left;
        int right;
        int target;
        for (int i = 0; i < len; i++) {
            target = -nums[i];
            left = i + 1;
            right = len - 1;
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[right]);
                    cur.add(nums[left]);
                    res.add(cur);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
