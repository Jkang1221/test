package com.leetCode.slidingWindow;

import java.util.Arrays;

public class minimumWindowSubstring76 {
    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int[] window = new int[128];
        //用来计算子字符串各个字母出现的次数
        int[] partten = new int[128];
        for (Character c : t.toCharArray()) {
            //System.out.println(c - 'A');
            partten[c - 'A']++;
        }
        int distance = 0;
        for (int i = 0; i < 128; i++) {
            if (partten[i] > 0) {
                distance++;
            }
        }
        int right = 0, left = 0;
        int len = s.length();
        int minLen = len + 1;
        int match = 0;
        int start = 0;
        while (right < len) {
            Character curRight = s.charAt(right);
            if (partten[curRight - 'A'] > 0) {
                window[curRight - 'A']++;
                if (partten[curRight - 'A'] == window[curRight - 'A']) {
                    match++;
                }
            }
            right++;
            while (match == distance) {
                Character leftChar = s.charAt(left);
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                if (partten[leftChar - 'A'] > 0) {
                    window[leftChar - 'A']--;
                    if (window[leftChar - 'A'] < partten[leftChar - 'A']) {
                        match--;
                    }
                }
                left++;
            }
        }
        return minLen == len + 1 ? "" : s.substring(start, start + minLen);
    }
}
