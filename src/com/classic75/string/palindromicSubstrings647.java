package com.classic75.string;

public class palindromicSubstrings647 {
    public static void main(String[] args) {

    }

    public static int countSubstrings(String s) {
        int right = 0;
        int left = 0;
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int result = 0;
            count += countSub(s, i, i, len, result);
            count += countSub(s, i, i + 1, len, result);
        }
        return count;
    }

    public static int countSub(String s, int i, int j, int len, int result) {
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            result++;
            i--;
            j++;
        }
        return result;
    }

    public static int countSubstrings2(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i)==s.charAt(j)){
                    if (j-i<=1){
                        dp[i][j]=true;
                        result++;
                    }else if (dp[i+1][j-1]){
                        dp[i][j]=true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
