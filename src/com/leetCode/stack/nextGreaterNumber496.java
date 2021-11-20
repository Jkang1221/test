package com.leetCode.stack;

import java.util.*;

public class nextGreaterNumber496 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        nextGreaterElement(nums1,nums2);
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1];
        int[] result2 = new int[len2];

        //使用栈求出来nums2的每一个元素比他大的值的位置
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && nums2[stack.peekLast()] < nums2[i]) {
                map.put(nums2[stack.removeLast()],nums2[i]);
                //result2[stack.removeLast()] = nums2[i];
            }
            stack.addLast(i);
        }
        System.out.println(map.toString());
        for (int i = 0; i < len1; i++){
            result[i] = map.getOrDefault(nums1[i],-1);
        }
        return result;
    }

}
