package com.classic75.string;

public class longestSubstring3 {
    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int[] nums = new int[128];
        for(int i = 0;i<128;i++){
            nums[i] = 0;
        }
        int left = 0;
        int right = 0;
        int count = 1;
        int len = s.length();
        if(len<2){
            return len;
        }
        for(;right<len;right++){
            nums[s.charAt(right)]++;
            if(nums[s.charAt(right)]==2){
                while(nums[s.charAt(right)]==2){
                    nums[s.charAt(left)]--;
                    left++;
                }
            }
            count = Math.max((right - left + 1), count);
        }
        return count;
    }
}
