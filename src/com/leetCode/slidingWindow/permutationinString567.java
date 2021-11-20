package com.leetCode.slidingWindow;

import java.util.Arrays;

public class permutationinString567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "a";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] pattern = new int[26];
        int distance = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2){
            return false;
        }
        for (int i = 0; i < len1; i++) {
            pattern[s1.charAt(i) - 'a']++;
        }
        //System.out.println(Arrays.toString(pattern));
        for (int i = 0; i < 26; i++) {
            if (pattern[i] > 0) {
                distance++;
            }
        }
        int left = 0;
        int right = 0;
        int match = 0;
        int[] windows = new int[26];
        int minLen = len2+1;
        while (right < len2) {
            Character curChar = s2.charAt(right);
            if (pattern[curChar - 'a']>0){
                windows[curChar-'a']++;
                if(pattern[curChar - 'a']==windows[curChar-'a']){
                    match++;
                }
            }
            right++;
            while (match == distance){
                Character leftChar = s2.charAt(left);
                if (pattern[leftChar - 'a']>0){
                    windows[leftChar - 'a']--;
                    if (windows[leftChar - 'a']<pattern[leftChar-'a']){
                        match--;
                        minLen = Math.min(minLen,right-left);
                    }
                }
                left++;
            }
        }
        return minLen == len1;
    }
}
