package com.leetCode;

import java.util.Arrays;
import java.util.Random;

public class sortSelect912 {
    public static void main(String[] args) {
        int[] num = new int[]{5, 1, 1, 2, 0, 0};
        Solution912 solution912 = new Solution912();
        sortArray(num);
        System.out.println(Arrays.toString(num));
    }
    public static int[] sortArray(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }
        sortQucik(nums, 0, len - 1);
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    private static void sortQucik(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(nums, left, right);
        sortQucik(nums, left, p - 1);
        sortQucik(nums, p + 1, right);
    }

    private static final Random RANDOM = new Random();

    private static int partition(int[] nums, int left, int right) {
        int r = left + RANDOM.nextInt(right - left + 1);
        swap(nums, left, r);
        int povit = nums[left];
        int lt = left + 1;
        int rt = right;
        while (true) {
            while (lt <= rt && nums[lt] < povit) {
                lt++;
            }
            while (lt <= rt && nums[rt] > povit) {
                rt--;
            }
            if (lt > rt) {
                break;
            }
            swap(nums,lt,rt);
            lt++;
            rt--;
        }
        swap(nums,left,rt);
        return rt;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int tem = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tem;
    }
}

class Solution912 {
    /* public int[] sortArray(int[] nums) {
        //方法一：冒泡排序

       for(int i = 0;i<nums.length -1;i++){
            for(int j = 0;j<nums.length -1 - i;j++){
                if(nums[j] > nums[j+1]){
                    int tem = nums[j + 1];
                    nums[j+1] = nums[j];
                    nums[j] = tem;
                }
            }
        }*/
    //方法二：快排
/*        int min = 0;
        for(int i = 0;i<nums.length - 1;i++){
            min = i;
            for(int j = i+1;j<nums.length ;j++){
                if(nums[min]>nums[j]){
                    min = j;
                }
            }
            int tmp = nums[min];
            nums[min] = nums[i];
            nums[i] = tmp;
        }
        return nums;


    }*/
    //方法三：插入排序
    /*public int[] sortArray(int[] nums) {
        int len = nums.length;
        for(int i = 0;i<len;i++){
            for(int j = i;j>0;j--){
                if(nums[j-1]>nums[j]){
                    swap(nums,j-1,j);
                }else {
                    break;
                }
            }
        }
        return nums;
    }

    public void swap(int[] nums,int index1,int index2){
        int tem = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tem;
    }*/
    public static   int[] sortArray(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }
        sortQucik(nums, 0, len - 1);
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    private static void sortQucik(int[] nums, int left, int right) {
        if (left < right) {
            return;
        }
        int p = partition(nums, left, right);
        sortQucik(nums, left, p - 1);
        sortQucik(nums, p + 1, right);
    }

    private static final Random RANDOM = new Random();

    private static int partition(int[] nums, int left, int right) {
        int r = left + RANDOM.nextInt(right - left + 1);
        swap(nums, left, r);
        int povit = nums[left];
        int lt = left + 1;
        int rt = right;
        while (true) {
            while (lt < rt && nums[lt] < povit) {
                lt++;
            }
            while (lt < rt && nums[rt] > povit) {
                rt--;
            }
            if (lt > rt) {
                break;
            }
            swap(nums,lt,rt);
            lt++;
            rt--;
        }
        return rt;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int tem = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tem;
    }

}