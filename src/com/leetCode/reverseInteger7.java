package com.leetCode;

public class reverseInteger7 {
    public static void main(String[] args) {
        int x = 901000;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tmp = x % 10;
            if ((result == Integer.MAX_VALUE / 10 && tmp > 7) || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if ((result == Integer.MIN_VALUE / 10 && tmp < -8)||result<Integer.MIN_VALUE/10){
                result = result * 10 + tmp;
            }
            x = x / 10;
        }
        return result;
    }
}
