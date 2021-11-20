package com.leetCode.slidingWindow;

public class longestRepeatingCharacterReplacement424 {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int[] arr = new int[26];
        int maxSame = 0;
        int right = 0;
        int left = 0;
        while (right < len) {
            arr[s.charAt(right) - 'A']++;
            maxSame = Math.max(maxSame, arr[s.charAt(right) - 'A']);
            while (right - left + 1 > maxSame + k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return len - left;
    }
}
