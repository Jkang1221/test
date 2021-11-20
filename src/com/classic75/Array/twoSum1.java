package com.classic75.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 18;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> res = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {

            if (res.containsKey(target - nums[i])) {
                return new int[]{res.get(target - nums[i]),i};
            }
            res.put(nums[i], i);
        }
        return null;
    }
}
