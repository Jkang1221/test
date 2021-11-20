package com.leetCode;

import java.util.Arrays;

public class longestSubstringWithoutRepeatingChar3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s));
    }

    //优化前
    public static int lengthOfLongestSubstring1(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int[] arr = new int[128];
        int right;
        int left;
        int res = 1;
        char[] charArray = s.toCharArray();
        for (right = 0, left = 0; right < len; right++) {
            arr[charArray[right]]++;
            if (arr[charArray[right]] == 2) {
                while (arr[charArray[right]] == 2) {
                    arr[charArray[left]]--;
                    left++;
                }
            }
            res = Math.max((right - left + 1), res);
        }
        return res;
    }

    //优化后
    public static int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] charArray = s.toCharArray();
        int[] arr = new int[128];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        int left = 0;
        int res = 1;
        for (int right = 0; right < len; right++) {
            if (arr[charArray[right]] != -1) {
                left = Math.max(left, arr[charArray[right]]);
            }
            arr[charArray[right]] = right;
            System.out.println(arr[charArray[right]]);
            res = Math.max(res,right - left + 1);
        }
        System.out.println(charArray.toString());
        return res;
    }
}
