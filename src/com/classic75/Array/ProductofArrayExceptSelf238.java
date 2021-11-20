package com.classic75.Array;

import java.util.Arrays;

public class ProductofArrayExceptSelf238 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
    }

    //方法一：
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int mutiply = nums[0];
        for (int i = 1; i < len; i++) {
            mutiply *= nums[i];
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                res[i] = result(i, nums);
            } else {
                res[i] = mutiply / nums[i];
                ;
            }

        }
        return res;
    }

    private static int result(int index, int[] nums) {
        int res = 1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i != index) {
                res = nums[i] * res;
            }
        }
        return res;
    }

    //方法二：
    public static int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];
        int[] res = new int[len];
        L[0] = 1;
        R[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        //System.out.println(Arrays.toString(L));
        for (int i = len - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        //System.out.println(Arrays.toString(R));
        for (int i = 0; i < len; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }
}
