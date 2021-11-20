package com.codesingal;

import java.util.Arrays;

public class test1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 4};
        System.out.println(Arrays.toString(isZigzag(nums)));
    }

    public static int[] isZigzag(int[] numbers) {
        int len = numbers.length;
        int[] res = new int[len - 2];
        for (int i = 0; i < len - 2; i++) {
            res[i] = isMount(numbers[i],numbers[i+1],numbers[i+2]);
        }
        return res;
    }

    public static int isMount(int n1, int n2, int n3) {
        if (n2 > n1 && n2 > n3) {
            return 1;
        } else if (n1 > n2 && n3 > n2){
            return 1;
        }else {
            return 0;
        }
    }
}
