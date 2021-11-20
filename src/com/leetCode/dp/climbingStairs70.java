package com.leetCode.dp;

public class climbingStairs70 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n) {
        if(n<2){
            return 1;
        }
        int[] ways = new int[n+1];
        ways[0]=1;
        ways[1]=1;
        for (int i = 2;i<n+1;i++){
            ways[i] = ways[i-1]+ways[i-2];
        }
        return ways[n];
    }
}
