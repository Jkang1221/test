package com.leetCode.dp;

public class fibonacciNumber509 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < (n + 1); i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
