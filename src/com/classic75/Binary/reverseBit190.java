package com.classic75.Binary;

public class reverseBit190 {
    public static void main(String[] args) {
        int n = -3;
        reverseBits(n);
    }

    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int j = 1 & (n >> i);
            res += j << (31 - i);
        }
        return res;
    }
}
