package com.classic75.Binary;

import java.util.ArrayList;
import java.util.List;

public class sumofTwoIntegers371 {
    public static void main(String[] args) {
        int a = 3;
        int b = 1;
        System.out.println(getSum(a, b));
    }

    public static int getSum(int a, int b) {
        while(b!=0){
            int carry = (a&b)<<1;
            a = a^b;
            b = carry;
        }
        return a;
    }
}
