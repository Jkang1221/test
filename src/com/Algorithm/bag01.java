package com.Algorithm;

import java.util.Arrays;

public class bag01 {
    public static void main(String[] args) {
        int[] weight = new int[]{1, 3, 4};
        int[] value = new int[]{15, 20, 30};
        int bagWeight = 4;
        System.out.println(first(weight, value, bagWeight));
        System.out.println(second(weight,value,bagWeight));
    }

    public static int first(int[] weight, int[] value, int bagWeight) {
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < bagWeight; i++) {
            dp[i] = 0;
        }
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j - weight[i]] + value[i], dp[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[bagWeight];
    }

    public static int second(int[] weight, int[] value, int bagWeight) {
        int len = weight.length;
        int[][] dp = new int[len][bagWeight + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < bagWeight + 1; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = weight[0]; i < bagWeight + 1; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = weight[0]; j < bagWeight + 1; j++) {
                if (j > weight[i]) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[len-1][bagWeight];
    }
}
