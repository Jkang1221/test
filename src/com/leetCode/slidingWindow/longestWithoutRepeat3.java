package com.leetCode.slidingWindow;

public class longestWithoutRepeat3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int right = 0;
        int left = 0;
        int res = 0;
        int[] arr = new int[128];
        char[] ch = s.toCharArray();
        System.out.println(arr[ch[3]]);
        for (; right < len; right++) {
            arr[ch[right]]++;
            if (arr[ch[right]] == 2) {
                while (arr[ch[right]]==2) {
                    arr[ch[left]]--;
                    left++;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        //System.out.println((int)(ch[3]-'a'));
        return res;
    }
}
