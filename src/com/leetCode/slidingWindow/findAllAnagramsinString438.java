package com.leetCode.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class findAllAnagramsinString438 {
    public static void main(String[] args) {
        String s = "abaacbabc";
        String p = "abc";
        System.out.println(findAnagrams(s, p));

    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int len1 = s.length();
        int len2 = p.length();
        int[] pattern = new int[26];
        int[] window = new int[26];
        int distance = 0;
        for (int i = 0; i < len2; i++) {
            pattern[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (pattern[i] > 0) {
                distance++;
            }
        }
        int left = 0;
        int right = 0;
        int match = 0;
        while (right < len1) {
            Character curChar = s.charAt(right);
            if (pattern[curChar - 'a'] > 0) {
                window[curChar - 'a']++;
                if (window[curChar - 'a'] == pattern[curChar - 'a']) {
                    match++;
                }
            }
            right++;
            while (match == distance) {
                Character leftChar = s.charAt(left);

                if (pattern[leftChar - 'a'] > 0) {
                    window[leftChar - 'a']--;
                    if (window[leftChar - 'a'] < pattern[leftChar - 'a']) {
                        match--;
                        if ((right - left) == len2) {
                            list.add(left);
                        }
                    }
                }
                left++;
            }
        }
        return list;
    }
}
