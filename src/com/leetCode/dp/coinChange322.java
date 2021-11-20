package com.leetCode.dp;

import java.util.Arrays;

public class coinChange322 {
    public static void main(String[] args) {

    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[coins.length+1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp,max);
        for (int i = 0;i<coins.length;i++){
            for (int j = coins[i];j<=amount;j++){
                if (dp[j-coins[i]]!=max){
                    dp[j] = Math.max(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[coins.length]==max? -1:dp[coins.length];
    }
}
