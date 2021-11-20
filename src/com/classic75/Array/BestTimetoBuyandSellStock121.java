package com.classic75.Array;

public class BestTimetoBuyandSellStock121 {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        //最大的利润
        int maxProfit = 0;
        //最低的价格
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            minPrice = minPrice > prices[i] ? prices[i] : minPrice;
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }
}
