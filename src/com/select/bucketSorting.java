package com.select;

import java.util.Arrays;

public class bucketSorting {
    public static void main(String[] args) {
        int[] nums = new int[]{41, 12, 14, 32, 23};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] num) {
        int len = num.length;
        int max = num[0];
        for (int i = 1; i < len; i++) {
            if (max < num[i]) {
                max = num[i];
            }
        }
        //计算出最大的数字有几位，这个数值决定了桶的个数
        int maxLen = getMaxLen(max);
        //步长
        int step = 1000;
        if (maxLen < 5) {
            step = (int) Math.pow(10, maxLen - 1);
        }
        //桶的个数
        int bucketLen = max / step + 1;
        int[][] temp = new int[bucketLen][len];
        int[] next = new int[bucketLen];
        //分桶
        for (int i = 0; i < len; i++) {
            int bucketIndex = num[i] / step;
            temp[bucketIndex][next[bucketIndex]] = num[i];
            next[bucketIndex]++;
        }
        //排序
        for (int i = 0; i < bucketLen; i++) {
            insertionSort(temp[i], next[i] - 1);
        }
        //从桶里依次取出来
        int index = 0;
        for (int i = 0; i < bucketLen; i++) {
            int curLen = next[i];
            for (int j = 0; j < curLen; j++) {
                num[index] = temp[i][j];
                index++;
            }
        }
    }

    public static void insertionSort(int[] arr, int endIndex) {
        for (int i = 1; i < endIndex; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private static int getMaxLen(int max) {
        int maxLen = 0;
        while (max > 0) {
            max = max / 10;
            maxLen++;
        }
        return maxLen;
    }
}
