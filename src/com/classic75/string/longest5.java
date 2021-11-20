package com.classic75.string;

public class longest5 {


    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome2(s));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int right = 0;
        int left = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            int len1 = extend(s, i, i, len);
            int len2 = extend(s, i, i + 1, len);
            int len3 = Math.max(len1, len2);
            if (len3 > maxLen) {
                maxLen = len3;
                left = i - (len3 - 1) / 2;
                right = i + len3 / 2;
            }
        }
        return s.substring(left, left + maxLen);
    }

    public static int extend(String s, int i, int j, int len) {
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public static String longestPalindrome2(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int left = 0;
        int maxLen = 0;
        int right = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    //i，j相等，或者某个连续的字母
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        //根据之前来判断
                    } else if(dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
                if(dp[i][j]&& j - i + 1>maxLen){
                    maxLen = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        //System.out.println(dp[0][len]);
        return s.substring(left, left + maxLen);
    }
}
