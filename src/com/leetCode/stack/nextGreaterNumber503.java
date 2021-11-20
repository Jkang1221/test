package com.leetCode.stack;

import java.util.*;

public class nextGreaterNumber503 {
    public static void main(String[] args) {
        int[] nums = new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));

    }

    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] newNums = new int[len];
        for (int i = 0; i < len; i++) {
            newNums[i] = -1;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peekLast()]) {
                Integer site = stack.removeLast();
                newNums[site] = nums[i % len];
            }
            stack.addLast(i % len);
        }
        return newNums;
    }
}
