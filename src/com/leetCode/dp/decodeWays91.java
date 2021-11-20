package com.leetCode.dp;

import java.util.Arrays;

public class decodeWays91 {
    public static void main(String[] args) {
        String s = "301";
        System.out.println(numDecodings(s));

    }

    public static int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        System.out.println(s.charAt(s.length() - 1));
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            String temp = s.substring(i - 2, i);
            if ((temp.charAt(0) == '0' && temp.charAt(1) == '0') ||
                    (temp.charAt(1) == '0' && temp.charAt(0) > '2')
            ) {
                return 0;
            }
            if (temp.charAt(0) == '0') {
                dp[i] = dp[i - 1];
            } else if (temp.compareTo("10") == 0 || temp.compareTo("20") == 0) {
                dp[i] = dp[i - 2];
                dp[i - 1] = dp[i - 2];
            } else {
                //System.out.println(i);
                dp[i] = temp.compareTo("10") > 0 && temp.compareTo("26") <= 0 ? dp[i - 1] + dp[i - 2] : dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
