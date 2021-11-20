package com.classic75.Binary;

public class numberof1bits191 {
    public static void main(String[] args) {
        int n = 15;
        hammingWeight(n);
    }

    public static int hammingWeight(int n) {
        int count = 0;
        String tem = Integer.toBinaryString(n);
        for (int i = 0; i < tem.length(); i++) {
            if((n& 1<<i)!=0){
                count++;
            }
            System.out.println(n& 1<<i);
        }
        return count;
    }
}
