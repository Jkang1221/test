package com.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class singleNumber136 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (Integer i : nums) {
            if (!res.contains(i)) {
                res.add(i);
            } else {
                res.remove(i);
            }
        }
        return res.get(0);
    }
}
