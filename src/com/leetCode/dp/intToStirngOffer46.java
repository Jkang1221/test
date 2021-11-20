package com.leetCode.dp;

import java.util.Arrays;

public class intToStirngOffer46 {
    public static void main(String[] args) {
        int n = 230;
        System.out.println(translateNum(n));
    }

    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i<dp.length;i++){
            String temp = s.substring(i-2,i);
            dp[i] = temp.compareTo("10")>=0 && temp.compareTo("25")<=0? dp[i-2]+dp[i-1]:dp[i-1];
        }
        return dp[s.length()];
    }
}
