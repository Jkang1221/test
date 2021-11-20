package com.classic75.dynamicProgramming;

import java.util.Arrays;

public class coinChange322 {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return dp(coins, amount);
    }

    private static int dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j-coins[i]]!=max){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount]==max?-1:dp[amount];
    }
}
